(ns gramophone.controller
  (:import (org.springframework.stereotype Controller)
           (org.springframework.web.bind.annotation RequestMapping RequestMethod ResponseBody)
           (javax.servlet.http HttpServletRequest)))

(gen-class
  :name ^{Controller ""} gramophone.controller.HelloController
  :methods [[^{RequestMapping {:value  ["/hello"]
                               :method [RequestMethod/GET]}
               ResponseBody {}} hello [javax.servlet.http.HttpServletRequest] String]])

(defn -hello
  [this ^HttpServletRequest request]
  (str (.getParameter request "name") "hello" "world"))