(ns project-euler.problem-73)

(require '[clojure.math.numeric-tower :as math])


(defn reduce-while-even
  "If a and b are both even then it divides them both by two until one is not even and returns them and the count of divisions d"
  [a b d]
  (if
    (and (even? a) (even? b))
    (reduce-while-even (/ a 2) (/ b 2) (+ d 1))
    [a b d]))

(defn reduce-while-not-equal
  "Reduces a and b further and returns a value for g"
  [a b]
  (if
    (not= a b)
    (cond
      (even? a) (reduce-while-not-equal (/ a 2) b)
      (even? b) (reduce-while-not-equal a (/ b 2))
      (> a b) (reduce-while-not-equal (/ (- a b) 2) b)
      :else (reduce-while-not-equal a (/ (- b a) 2)))
    a ))

(defn hcf
  "Highest common factor of n, d. Binary method of computation. https://en.wikipedia.org/wiki/Greatest_common_divisor"
  ;thought I might have needed this to reduce some fractions but ended up not
  [a b]

  (let [[a2 b2 d] (reduce-while-even a b 0)]
    (def g (reduce-while-not-equal a2 b2))
    (* g (math/expt 2 d))))


(defn count-fractions
  [min max d-max]

  "Counts the unique irreducible fractions between [min] and [max] that have a denominator up to [d-max]"
  (count
    (distinct
      (for [d (range (+ d-max 1))
            n (range (int (Math/ceil (* d min))) (int (Math/floor (* d max))))
              :when (> (/ n d ) min)] ;don't include values equal to min
          (/ n d)))))


(count-fractions (/ 1 3) (/ 1 2) 12000)