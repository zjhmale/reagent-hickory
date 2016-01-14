(ns reagent-hickory.sweet-spec
  #+clj (:require [speclj.core :refer :all]
                  [reagent-hickory.templates :refer [deftemplate]])
  #+cljs (:require-macros
           [speclj.core :refer [describe it should=]]
           [reagent-hickory.templates :refer [deftemplate]])
  #+cljs (:require [speclj.core])
  (:use [reagent-hickory.sweet :only [html->hiccup]]))

(deftemplate example "example.html")
(deftemplate withcomments "withcomments.html")

(describe "test html -> hiccup"
  (it "html str -> hiccup"
      (should= [:p {:class "someclass"} [:span {} "I have "] [:strong {} "bold"] [:span {:style {"color" "red"}} " and red "] [:span {} "text."]]
               (html->hiccup "<p class=\"someclass\"><span>I have </span><strong>bold</strong><span style=\"color:red;\"> and red </span><span>text.</span></p>")))
  (it "html file -> hiccup"
      (should= [:div {:id "navbar"}
                [:ul {}
                 [:li {}
                  [:a {:href "/"} "dashboard"]
                  ]
                 [:li {}
                  [:a {:class "muted"} "robot (stage禁用)"]
                  [:a {:href "/robot"} "robot"]
                  ]
                 [:li {}
                  [:a {:href "/feedbacks"} "feedbacks"]
                  ]
                 [:li {}
                  [:a {:href "/teams"} "teams"]
                  ]
                 [:li {}
                  [:a {:href "/human_assistant"} "human assistant"]
                  ]
                 [:li {}
                  [:a {:href "/features"} "features"]
                  ]
                 [:li {}
                  [:a {:href "/refresh"} "refresh"]
                  ]
                 ]
                ]
               example))
  (it "html file with comments -> hiccup"
      (should= [:div {:id "navbar"}
                [:ul {}
                 [:li {}
                  [:a {:href "/"} "dashboard"]
                  ]
                 [:li {}
                  [:a {:class "muted"} "robot (stage禁用)"]
                  [:a {:href "/robot"} "robot"]
                  ]
                 [:li {}
                  [:a {:href "/feedbacks"} "feedbacks"]
                  ]
                 [:li {}
                  [:a {:href "/teams"} "teams"]
                  ]
                 [:li {}
                  [:a {:href "/human_assistant"} "human assistant"]
                  ]
                 [:li {}
                  [:a {:href "/features"} "features"]
                  ]
                 [:li {}
                  [:a {:href "/refresh"} "refresh"]
                  ]
                 ]
                ]
               withcomments)))
