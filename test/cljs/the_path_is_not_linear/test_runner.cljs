(ns the-path-is-not-linear.test-runner
  (:require
   [doo.runner :refer-macros [doo-tests]]
   [the-path-is-not-linear.core-test]
   [the-path-is-not-linear.common-test]))

(enable-console-print!)

(doo-tests 'the-path-is-not-linear.core-test
           'the-path-is-not-linear.common-test)
