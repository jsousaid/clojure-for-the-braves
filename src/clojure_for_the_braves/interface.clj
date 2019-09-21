(ns clojure-for-the-braves.interface)

(defmulti validate-user-info
  (fn [user-info]
     (:type user-info)))