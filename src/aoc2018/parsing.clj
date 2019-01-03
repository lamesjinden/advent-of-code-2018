(ns aoc2018.parsing)

(defn parse-int [^String x]
  (Integer/parseInt x))

(defn try-parse-int [^String x ^Integer fallback]
  (try (parse-int x)
       (catch NumberFormatException exception fallback)))
