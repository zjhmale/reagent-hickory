(defproject zjhmale/reagent-hickory "0.1.0"
  :description "an enhancement of using hickory to generate reagent style hiccup"
  :url "https://github.com/zjhmale/reagent-hickory"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [com.keminglabs/cljx "0.6.0"]
                 [hickory "0.6.0"]]
  :source-paths ["src" "target/generated-src"]
  :test-paths ["target/generated-test"]
  :aliases {"cleantest" ["do" "clean," "cljx" "once," "test,"
                         "cljsbuild" "once," "cljsbuild" "test"]}
  :cljx {:builds [{:source-paths ["src"]
                   :output-path  "target/generated-src"
                   :rules        :clj}
                  {:source-paths ["src"]
                   :output-path  "target/generated-src"
                   :rules        :cljs}
                  {:source-paths ["test"]
                   :output-path  "target/generated-test"
                   :rules        :clj}
                  {:source-paths ["test"]
                   :output-path  "target/generated-test"
                   :rules        :cljs}]}
  :cljsbuild {:builds        [{:source-paths  ["target/generated-src" "target/generated-test"]
                               :compiler      {:output-to "target/cljs/testable.js"}
                               :optimizations :whitespace
                               :pretty-print  true}]
              :test-commands {"unit-tests" ["runners/phantomjs.js" "target/cljs/testable.js"]}})
