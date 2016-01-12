(ns reagent-hickory.sweet-test
  #+clj (:require [clojure.test :refer :all])
  #+cljs (:require-macros [cemerick.cljs.test :refer (are is deftest with-test run-tests testing)])
  #+cljs (:require [cemerick.cljs.test :as t])
  (:use [reagent-hickory.sweet :only [html->hiccup]]))

(deftest test-html->hiccup
  #+clj (is (= [:p {:class "someclass"} [:span {} "I have "] [:strong {} "bold"] [:span {:style {"color" "red"}} " and red "] [:span {} "text."]]
         (html->hiccup "<p class=\"someclass\"><span>I have </span><strong>bold</strong><span style=\"color:red;\"> and red </span><span>text.</span></p>")))
  #+clj (is (= 1 1))
  #+cljs (is (= 1 1)))
