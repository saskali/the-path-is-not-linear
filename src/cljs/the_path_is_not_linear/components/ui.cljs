(ns the-path-is-not-linear.components.ui
  (:require [com.stuartsierra.component :as component]
            [the-path-is-not-linear.core :refer [render]]))

(defrecord UIComponent []
  component/Lifecycle
  (start [component]
    (render)
    component)
  (stop [component]
    component))

(defn new-ui-component []
  (map->UIComponent {}))
