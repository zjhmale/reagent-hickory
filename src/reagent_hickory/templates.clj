(ns reagent-hickory.templates)

(defmacro deftemplate
  [symbol-name html-name]
  (let [content (slurp (str "resources/public/templates/" html-name))]
    `(def ~symbol-name
       ~content)))
