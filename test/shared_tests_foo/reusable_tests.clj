(ns shared-tests-foo.reusable-tests
  (:require [clojure.test :refer :all]
            [shared-tests-foo.core :as core]))

(def ^{:dynamic true} *subject*)

(deftest funktastest
  (println "RUNNING FUNKTASTEST")
  (is (= "foo" (core/foo *subject*))))
