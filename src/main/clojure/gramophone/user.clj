(ns gramophone.user
  (:require [gramophone.db :as db]))

(defn user-exist?
  [account]
  (true? (db/query-user-by-account account)))

(defn add-user
  [account password nick sex mobile email]
  (let [user {:account account :passwd password
              :nick nick :sex sex :mobile mobile
              :email email}]
    (if (user-exist? account)
      (throw (IllegalArgumentException. "account has existed"))
      (db/insert-user user))))

(defn all-users
  []
  (db/query-all-users))


