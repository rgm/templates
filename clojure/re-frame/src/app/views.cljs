(ns app.views
  (:require
   [re-frame.core :as rf]))

(defn Root []
  (let [*n (rf/subscribe [:current-counter-value])]
    (fn []
      [:main
       [:div "counter is: " [:strong (deref *n)]]
       [:div
        [:button
         {:on-click (fn [_ev] (rf/dispatch [:increment]))}
         "increment"]]])))
