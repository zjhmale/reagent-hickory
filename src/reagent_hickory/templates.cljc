(ns reagent-hickory.templates
  (:require [reagent-hickory.sweet :refer [html->hiccup]]))

(defmacro deftemplate
  [symbol-name html-name]
  (let [content (slurp (str "src/templates/" html-name))]
    `(def ~symbol-name
       ~(html->hiccup content))))

(defmacro deftemplatefn
  [symbol-name html-name]
  (let [content (slurp (str "src/templates/" html-name))]
    `(defn ~symbol-name []
       ~(html->hiccup content))))