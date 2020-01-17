(ns cpcp.core)

;; c.f.: https://en.wikipedia.org/wiki/Continuation-passing_style

(defn *& [x y k]
  (k (* x y)))

(defn -& [x y k]
  (k (- x y)))

(defn =& [x y k]
  (k (= x y)))

(defn factorial& [n k]
  (=& n 0 (fn [b]
            (if b                  ;; growing continuation
              (k 1)                ;; in the recursive call
              (-& n 1 (fn [nm1]
                        (factorial& nm1 (fn [f]
                                          (*& n f k)))))))))

;; Problem 1: how the !*!^@^& do you call it?

;; Problem 2: Implement
;; GCD(https://en.wikipedia.org/wiki/Euclidean_algorithm) in CPS.

;; Problem 3: Implement something to give the nth fibonacci number

;; Problem 4: Implement and demonstrate an exception handler, without
;; try/catch, in Clojure along the lines of /& shown on the Wikipedia
;; page.

;; See also: SICP, p. 426.
