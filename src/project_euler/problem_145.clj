(ns project-euler.problem-145)

(require '[clojure.string :as s])

(defn reverse-int
  "Reverses an integer"
  [x]
  (Integer. (s/reverse (str x))))

(defn add-reverse
  "Adds the reverse of an integer to the integer"
  [x]
  (+ x (reverse-int x)))

(defn break-int [x]
  "Breaks apart an integer into a list of integers"
  (map (fn [s] (Integer. (str s)))  (str x)))

(defn int-contains-even?
  "Returns true if one of the digits in an integer is even"
  [x]
  (some identity (map even? (break-int x))))

(defn int-ends-in-zero?
  "Returns true if the integer ends in zero"
  [x]
  (= 0 (last (break-int x))))

(defn int-reversible?
  "Returns true if the integer is reversible"
  [x]
  (not
    (or
      (int-ends-in-zero? x)
      (int-contains-even? (add-reverse x)))))


(defn num-reversible
  "Returns the number of integers from zero to the max that are reversible"
  [max]
  (count (filter int-reversible? (range max))))


(num-reversible 1000000000) ;608720