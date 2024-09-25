(ns app.state
  (:require
   [re-frame.core :as rf]))

(rf/reg-event-db :init-app-db
  (fn [_app-db _event-vec]
    {:counter 0}))

(rf/reg-event-db :increment
  (fn [app-db _event-vec]
    (update app-db :counter inc)))

(rf/reg-sub :current-counter-value
  (fn [app-db _sub-vec]
    (get app-db :counter)))

(comment
  (rf/dispatch [:increment]))
