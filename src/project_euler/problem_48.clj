(ns project-euler.problem-48)

(require '[clojure.math.numeric-tower :as math])


(defn self-power
  [n]
  (math/expt n n))

(defn sum-self-powers
  [max]
  (apply + (for [n (range 1 (+ max 1))] (self-power n))))

(sum-self-powers 10)