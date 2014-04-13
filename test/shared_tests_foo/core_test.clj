(ns shared-tests-foo.core-test
  (:require [clojure.test :refer :all]
            [shared-tests-foo.core :as core]
            [shared-tests-foo.reusable-tests :as reusable]
            [clojure.pprint :as pprint]))

(defn run-shared-tests
  [shared-test-ns]
  (let [shared-results (clojure.test/run-tests shared-test-ns)]
    (pprint/pprint shared-results)
    (is (= (:pass shared-results) (:test shared-results)))
    (is (= 0 (:error shared-results)))
    (is (= 0 (:fail shared-results)))))

(deftest shared-tests
  (let [subject (reify core/FooProto
                  (foo [this] "foo"))]
    (binding [shared-tests-foo.reusable-tests/*subject* subject]
      (run-shared-tests 'shared-tests-foo.reusable-tests))))
