(ns the-path-is-not-linear.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as r]
            [cljs-time.core :as time]))

(defn home-render []
  [:div#map])

(defn home-did-mount [this]
  (let [map (.setView (.map js/L "map") #js [0 0] 3.2)]
    (.addTo (.tileLayer js/L "https://api.mapbox.com/styles/v1/mapbox/satellite-v9/tiles/256/{z}/{x}/{y}?access_token=pk.eyJ1Ijoic2Fza2FsaSIsImEiOiJjajZxd3ZkN3QwMzhrMzFtdG5leWg4MTgzIn0.9JyFhMiJO9bml-6o4bjMfw"
                      (clj->js {:attribution "Map data &copy; [...]"
                                :maxZoom 18}))
          map)))

(defn home []
  (reagent/create-class {:reagent-render home-render
                         :component-did-mount home-did-mount}))

(r/reg-event-db
  :initialize                  ;; id for initialize event
  (fn [_ _]                    ;; arguments: [db event]
      {:people []}))

(defn render []
  (reagent/render [home]
                  (.getElementById js/document "app")))
