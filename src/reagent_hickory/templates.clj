(ns reagent-hickory.templates
  (:require [reagent-hickory.sweet :refer [html->hiccup]]))

(defmacro deftemplate
  [symbol-name html-name]
  (let [content (slurp (str "resources/public/templates/" html-name))]
    `(def ~symbol-name
       ~(html->hiccup content))))
