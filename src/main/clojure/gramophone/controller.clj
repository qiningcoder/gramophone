(ns gramophone.controller
  (:require [gramophone.user :as user]
            [clojure.data.json :as json])
  (:import (org.springframework.stereotype Controller)
           (org.springframework.web.bind.annotation RequestMapping RequestMethod ResponseBody RequestParam)
           (javax.servlet.http HttpServletRequest)))

(gen-class
  :name ^{Controller ""} gramophone.controller.HelloController
  :methods [[^{RequestMapping {:value  ["/hello"]
                               :method [RequestMethod/GET]}
               ResponseBody {}} hello [^{RequestParam {:value "name"}} String] String]])

(defn json-result
  [code msg data]
  (json/json-str {:code code :msg msg :data data}))

(defn json-result-success
  ([data]
   (json-result 0 "success" data))
  ([]
    (json-result-success nil)))


(defn json-result-failure
  [msg]
  (json-result -1 msg nil))

(defn -hello
  [this ^String name]
  (str name #_(.getParameter request "name") "hello" "world"))

(gen-class
  :name ^{Controller ""} gramophone.controller.GmpController
  :methods [[^{RequestMapping {:value ["/user/register"]
                               :method [RequestMethod/GET]}
               ResponseBody {}} registerUser [javax.servlet.http.HttpServletRequest] String]
            [^{RequestMapping {:value ["/user/all"]
                               :method [RequestMethod/GET]}
               ResponseBody {}} getUsers [javax.servlet.http.HttpServletRequest] String]])

(defn -registerUser
  [this ^HttpServletRequest request]
  (let [account (.getParameter request "account")
        password (.getParameter request "password")
        nick (.getParameter request "nick")
        sex (.getParameter request "sex")
        mobile (.getParameter request "mobile")
        email (.getParameter request "email")]
    (try
      (user/add-user account password nick sex mobile email)
      (json-result-success)
      (catch Exception e (prn e) (json-result-failure "failed")))))

(defn -getUsers
  [this ^HttpServletRequest request]
  (let [account (.getParameter request "account")
        result (user/all-users)]
    (json-result-success result)))





