(ns gramophone.controller
  (:import (org.springframework.stereotype Controller)
           (org.springframework.web.bind.annotation RequestMapping RequestMethod ResponseBody RequestParam)
           (javax.servlet.http HttpServletRequest)))

(gen-class
  :name ^{Controller ""} gramophone.controller.HelloController
  :methods [[^{RequestMapping {:value  ["/hello"]
                               :method [RequestMethod/GET]}
               ResponseBody {}} hello [^{RequestParam {:value "name"}} String] String]])

(defn -hello
  [this ^String name]
  (str name #_(.getParameter request "name") "hello" "world"))