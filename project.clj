(defproject clojure-for-the-braves "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.0"]
		             [clj-time "0.15.2"]]
  :main ^:skip-aot clojure-for-the-braves.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})