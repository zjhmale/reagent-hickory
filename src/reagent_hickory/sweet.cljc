(ns reagent-hickory.sweet
  (:require [clojure.string :as s]
            [clojure.walk :as w]
            [hickory.core :as hc]
    #?(:cljs [goog.string :as gstring])))

(defn string->tokens
  "Takes a string with syles and parses it into properties and value tokens"
  [style]
  {:pre  [(string? style)]
   :post [(even? (count %))]}
  (->> (s/split style #";")
       (mapcat #(s/split % #":"))
       (map s/trim)))

(defn tokens->map
  "Takes a seq of tokens with the properties (even) and their values (odd)
   and returns a map of {properties values}"
  [tokens]
  {:pre  [(even? (count tokens))]
   :post [(map? %)]}
  (zipmap (keep-indexed #(if (even? %1) %2) tokens)
          (keep-indexed #(if (odd? %1) %2) tokens)))

(defn style->map
  "Takes an inline style attribute stirng and converts it to a React Style map"
  [style]
  (tokens->map (string->tokens style)))

(defn filter-angular
  "Remove ng-* angular tags from hiccup data structure"
  [attrs]
  (->> attrs
       (filter (fn [[key _]]
                 #?(:clj  (not (.startsWith (name key) "ng-"))
                    :cljs (not (gstring/startsWith (name key) "ng-")))))
       (into {})))

(defn hiccup->sablono
  "Transforms a style inline attribute into a style map for React"
  [coll]
  (w/postwalk
    (fn [x]
      (if (vector? x)
        (filterv identity x)
        x))
    (w/postwalk
      (fn [x]
        (when-not (and (string? x)
                       (or (re-matches #"\s+" x)
                           #?(:clj  (.startsWith x "<!--")
                              :cljs (gstring/startsWith x "<!--"))))
          (if (map? x)
            (filter-angular
              (if (contains? x :style)
                (update-in x [:style] style->map)
                x))
            x)))
      coll)))

(defn html->hiccup
  "translate html to hiccup captible with reagent"
  [html]
  (->> (hc/parse-fragment html)
       (map #(-> % hc/as-hiccup hiccup->sablono))
       (filter identity)
       first))
