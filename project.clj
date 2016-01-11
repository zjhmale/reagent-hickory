(defproject zjhmale/reagent-hickory "0.1.0"
  :description "an enhancement of using hickory to generate reagent style hiccup"
  :url "https://github.com/zjhmale/reagent-hickory"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [com.keminglabs/cljx "0.6.0"]]
  :main ^:skip-aot reagent-hickory.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
