(ns app.state
  (:require
   [re-frame.core :as rf]))

(rf/reg-event-db :init-app-db
  (fn [_app-db _event-vec]
    {}))

(rf/reg-sub :smoketest-sub
  (fn [_app-db _sub-vec]
    "re-frame is running"))
