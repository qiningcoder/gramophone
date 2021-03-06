(ns gramophone.db
  (:require [clojure.java.jdbc :as jdbc])
  (:import (org.apache.commons.dbcp BasicDataSource)))

(defn- pooled-spec
  [{:keys [classname url username password] :as other-spec}]
  {:datasource (doto (BasicDataSource.)
                 (.setDriverClassName classname)
                 (.setUrl url)
                 (.setUsername username)
                 (.setPassword password))})

(def pooled-db (pooled-spec {:classname "com.mysql.jdbc.Driver"
                           :url "jdbc:mysql://127.0.0.1:3306/gramophone?useUnicode=true&characterEncoding=UTF-8"
                           :username "root"
                           :password "123456"}))

(defn fetch-results
  [query]
  (jdbc/query pooled-db query))

(defn insert-user
  [user]
  (jdbc/insert! pooled-db :gmp_user user))