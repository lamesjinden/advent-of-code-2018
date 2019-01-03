(ns aoc2018.io
  (:require [clojure.string :as str])
  (:import [java.io File]))

(def fallback-prefix (str "resources" File/separator))

(defn get-fallback-path [^String file]
  (str fallback-prefix file))

(defn get-normalized-path [^String file]
  (let [exists? (-> (new File file) .isFile)
        fallback (get-fallback-path file)
        normalized (if exists? file fallback)]
    normalized))

(defn file->string [^String file]
  (-> file
      (get-normalized-path)
      (slurp)))

(defn file->strings [^String file]
  (-> file
      (file->string)
      (str/split-lines)))
