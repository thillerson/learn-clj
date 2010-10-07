#!/usr/bin/env clj

(ns mire.server
  (:use [clojure.contrib server-socket duck-streams]))

(def port 3333)
(def prompt "> ")

(defn mire-handle-client [in out]
  (binding [*in* (reader in)
            *out* (writer out)]
    (loop []
      (println (read-line))
      (recur))))

(def server (create-server port mire-handle-client))
