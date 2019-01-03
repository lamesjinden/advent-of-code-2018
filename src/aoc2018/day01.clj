(ns aoc2018.day01
  (:require [aoc2018.io :as aio]
            [aoc2018.parsing :as parsing]))

(def input-file "day01.input")
(def starting-frequency 0)

(defn part1 [starting-frequency numbers]
  (reduce + starting-frequency numbers))

(defn run-part1
  ([]
   (run-part1 input-file starting-frequency))
  ([input-file starting-frequency]
   (->> input-file
        (aio/file->strings)
        (map parsing/parse-int)
        (part1 starting-frequency))))

(defn create-starting-state [starting-frequency]
  {:current-value   starting-frequency
   :previous-values #{starting-frequency}})

(defn reducing-fn [{:keys [current-value previous-values] :as state} x]
  (let [next-value (+ current-value x)]
    (if (contains? previous-values next-value)
      (reduced next-value)
      (-> state
          (update-in [:previous-values] conj next-value)
          (assoc-in [:current-value] next-value)))))

(defn part2 [starting-frequency numbers]
  (let [starting-state (create-starting-state starting-frequency)]
    (->> numbers
         (cycle)
         (reduce reducing-fn starting-state))))

(defn run-part2
  ([]
   (run-part2 input-file starting-frequency))
  ([input-file starting-frequency]
   (->> input-file
        (aio/file->strings)
        (map parsing/parse-int)
        (part2 starting-frequency))))