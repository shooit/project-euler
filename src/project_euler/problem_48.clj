(ns project-euler.problem-48)

(require '[clojure.math.numeric-tower :as math])


(defn self-power
  "Returns the value of [n] to the power of [n]"
  [n]
  (math/expt n n))

(defn sum-self-powers
  "Sums all the self powers up to [max]"
  [max]
  (apply + (for [n (range 1 (+ max 1))] (self-power n))))

(sum-self-powers 10)