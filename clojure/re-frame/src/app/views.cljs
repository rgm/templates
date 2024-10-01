(ns app.views
  "View components."
  (:require
   [re-frame.core :as rf]))

(defn Root []
  (let [*n (rf/subscribe [:current-counter-value])
        handle-click (fn [_ev] (rf/dispatch [:increment]))]
    (fn []
      [:main
       [:div "counter is: " [:strong (deref *n)]]
       [:div
        [:button
         {:on-click handle-click}
         "increment"]]])))
