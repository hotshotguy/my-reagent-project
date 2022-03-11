(ns hotshot.core
  (:require [reagent.core :as reagent]
            [reagent.dom :as reagent-dom]))

(def state (reagent/atom {:i 0}))

(defn my-first-component []
  [:section
   [:div "Counter:" (:i @state)]
   [:div
    [:button {:on-click #(swap! state update :i inc)} "Inc"]]
   [:div
    [:button {:on-click #(swap! state update :i dec)} "Dec"]]])

(reagent-dom/render [my-first-component]
                    (js/document.getElementById "app"))
