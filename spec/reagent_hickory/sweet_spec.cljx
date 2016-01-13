(ns reagent-hickory.sweet-spec
  #+clj (:require [speclj.core :refer :all]
                  [reagent-hickory.templates :refer [deftemplate]])
  #+cljs (:require-macros
           [speclj.core :refer [describe it should=]]
           [reagent-hickory.templates :refer [deftemplate]])
  #+cljs (:require [speclj.core])
  (:use [reagent-hickory.sweet :only [html->hiccup]]))

(deftemplate example "example.html")

(describe "test html -> hiccup"
  (it "html str -> hiccup"
      (should= [:p {:class "someclass"} [:span {} "I have "] [:strong {} "bold"] [:span {:style {"color" "red"}} " and red "] [:span {} "text."]]
               (html->hiccup "<p class=\"someclass\"><span>I have </span><strong>bold</strong><span style=\"color:red;\"> and red </span><span>text.</span></p>")))
  (it "html file -> hiccup"
      (should= [:div {:id "navbar"} "\n    " [:ul {} "\n        " [:li {} "\n            " [:a {:href "/"} "dashboard"] "\n        "] "\n        " [:li {} "\n            " [:a {:class "muted"} "robot (stage禁用)"] "\n            " [:a {:href "/robot"} "robot"] "\n        "] "\n        " [:li {} "\n            " [:a {:href "/feedbacks"} "feedbacks"] "\n        "] "\n        " [:li {} "\n            " [:a {:href "/teams"} "teams"] "\n        "] "\n        " [:li {} "\n            " [:a {:href "/human_assistant"} "human assistant"] "\n        "] "\n        " [:li {} "\n            " [:a {:href "/features"} "features"] "\n        "] "\n        " [:li {} "\n            " [:a {:href "/refresh"} "refresh"] "\n        "] "\n    "] "\n"]
               example)))

