(ns app.main
  (:require
   ["react-dom/client" :refer [createRoot]]
   [app.state]
   [app.views]
   [re-frame.core      :as rf]
   [reagent.core       :as rg]))

(defonce *REACT-ROOT (atom nil))

(defn ^:dev/after-load start
  "Mount the react root. Re-runs every hot reload."
  []
  (rf/clear-subscription-cache!)
  (.render (deref *REACT-ROOT) (rg/as-element [app.views/Root])))

(defn ^:export init
  "Initialize the app db, then mount. Runs only on first page load."
  []
  (rf/dispatch-sync [:init-app-db])
  (reset! *REACT-ROOT (createRoot (js/document.getElementById "app")))
  (start))
