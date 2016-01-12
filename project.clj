(defproject zjhmale/reagent-hickory "0.1.0"
  :description "an enhancement of using hickory to generate reagent style hiccup"
  :url "https://github.com/zjhmale/reagent-hickory"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [hickory "0.6.0"]
                 [org.clojure/clojurescript "0.0-3308"]
                 [speclj "3.3.1"]
                 [com.keminglabs/cljx "0.6.0"]]

  :plugins [[speclj "3.3.1"]
            [lein-cljsbuild "1.0.5"]
            [com.keminglabs/cljx "0.6.0"]]

  :cljsbuild {:builds        {:dev {:source-paths   ["target/generated/spec/cljs"]
                                    :compiler       {:output-to     "target/testable.js"
                                                     :optimizations :whitespace
                                                     :pretty-print  true}
                                    :notify-command ["phantomjs" "runners/speclj" "target/testable.js"]}}
              :test-commands {"test" ["phantomjs" "runners/speclj" "target/testable.js"]}}

  :cljx {:builds [{:source-paths ["src"]
                   :output-path  "target/generated/src/clj"
                   :rules        :clj}
                  {:source-paths ["src"]
                   :output-path  "target/generated/src/cljs"
                   :rules        :cljs}
                  {:source-paths ["spec"]
                   :output-path  "target/generated/spec/clj"
                   :rules        :clj}
                  {:source-paths ["spec"]
                   :output-path  "target/generated/spec/cljs"
                   :rules        :cljs}]}

  :source-paths ["src" "target/generated/src/clj" "target/generated/src/cljs"]
  :test-paths ["spec" "target/generated/spec/clj" "target/generated/spec/cljs"]

  :aliases {"pre-compile" ["do" "clean," "cljx"]
            "clj-test"    ["spec"]
            "cljs-test"   ["cljsbuild" "test"]
            "run-tests"   ["do" "pre-compile," "clj-test," "cljs-test"]})
