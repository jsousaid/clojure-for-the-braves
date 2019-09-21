(ns clojure-for-the-braves.core
  (:gen-class)
  (:require [clojure-for-the-braves.interface :as interface]))

(declare get-user-name get-user-age user-has-permission translate-age-try-again translate-name-try-again)

(def permission {:access "have" :dont-access "do not have"})


(def amount-for-sum (atom 0))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (let [user-name (get-user-name)
        user-age (get-user-age)
        user-authorized-key (user-has-permission user-age)]
    (println "Your name: => " user-name)
    (println "Your age => " user-age)
    (println "You" (user-authorized-key permission) "permission to access the system!")))

(defn get-user-name
  ([] (get-user-name {:try-again? false}))
  ([{:keys [try-again?]}]
    (loop [name-typed (do (print (translate-name-try-again try-again?)) (flush) (read-line))]
      (if (interface/validate-user-info {:type :name :name-typed name-typed})
        name-typed
        (recur (get-user-name {:try-again? true}))))))

(defn get-user-age
  ([] (get-user-age {:try-again? false}))
  ([{:keys [try-again?]}]
    (loop [age-typed (do (print (translate-age-try-again try-again?)) (flush) (read-line))]
      (if (interface/validate-user-info {:type :age :age-typed age-typed})
        (Integer. age-typed)
        (recur (get-user-age {:try-again? true}))))))

(defn user-has-permission
  [user-age]
  (if (>= user-age 18)
    :access
    :dont-access))

(defn translate-age-try-again
  [try-again?]
  (if try-again?
    "Age invalid, what's your age? "
    "What's your age? "))

(defn translate-name-try-again
  [try-again?]
  (if try-again?
    "Name invalid, what's your name? "
    "What's your name? "))

(defmethod interface/validate-user-info :name
  [user-info]
  (not (empty? (:name-typed user-info))))

(defmethod interface/validate-user-info :age
  [user-info]
  (try (Integer. (:age-typed user-info)) (catch NumberFormatException e false)))