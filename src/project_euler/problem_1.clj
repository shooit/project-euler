(ns project-euler.problem-1)

(defn mults
  "Returns the multiples of 3 and 5 up to [x]"
  [x]

  (filter (fn [i]
            (or (= 0 (mod i 3)) (= 0 (mod i 5))))
          (range x)))

(defn sum-mults
  "Returns the sum of the multiples up to [max]"
  [max]
  (reduce + (mults max)))

(sum-mults 1000) ;233168