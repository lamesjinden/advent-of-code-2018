(ns aoc2018.day01_test
  (:require [clojure.test :refer :all]
            [aoc2018.day01 :refer :all]))

(def test0 [1 -2 3 1]) ;2
(def test1 [1 -1]) ;0
(def test2 [3 3 4 -2 -4]) ;10
(def test3 [-6 3 8 5 -6]) ;5
(def test4 [7 7 -2 -7 -4]) ;14

(deftest sample-input-0
  (testing "sample input 0 yields 2"
    (is (= 2 (part2 starting-frequency test0)))))

(deftest sample-input-1
  (testing "sample input 1 yields 0"
    (is (= 0 (part2 starting-frequency test1)))))

(deftest sample-input-2
  (testing "sample input 2 yields 10"
    (is (= 10 (part2 starting-frequency test2)))))

(deftest sample-input-3
  (testing "sample input 3 yields 5"
    (is (= 5 (part2 starting-frequency test3)))))

(deftest sample-input-4
  (testing "sample input 4 yields 14"
    (is (= 14 (part2 starting-frequency test4)))))

(deftest quiz-input
  (testing "quiz input yields 72330"
    (is (= 72330 (run-part2)))))