(ns reagent-hickory.sweet-spec
  #+clj (:require [speclj.core :refer :all])
  #+cljs (:require-macros [speclj.core :refer [describe it should=]])
  #+cljs (:require [speclj.core])
  (:use [reagent-hickory.sweet :only [html->hiccup]]))

(describe "test html -> hiccup"
  (it "html -> hiccup"
      (should= [:p {:class "someclass"} [:span {} "I have "] [:strong {} "bold"] [:span {:style {"color" "red"}} " and red "] [:span {} "text."]]
               (html->hiccup "<p class=\"someclass\"><span>I have </span><strong>bold</strong><span style=\"color:red;\"> and red </span><span>text.</span></p>"))))

