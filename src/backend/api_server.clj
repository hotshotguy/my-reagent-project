(ns backend.api-server
  (:gen-class)
  (:require [org.httpkit.server :as server]))

(defonce ^:private api-server (atom nil))

(defn handler
  "A function that handles all requests from the server.
  Arguments: `req` is a ring request hash-map
  Return: ring response hash-map including :status :headers and :body"
  [req]
  {:status  200
   :headers {}
   :body    "Hello Clojure Server world!"})

(defn stop-server
  "Stop httpkit server"
  []
  (when-not (nil? @api-server)
    (@api-server :timeout 100)
    (reset! api-server nil)))

(defn -main
  "Start a httpkit server"
  [& {:keys [ip port]
      :or   {ip   "0.0.0.0"
             port 8000}}]
  (println "INFO: Starting httpkit server on port:" port)
  (reset! api-server (server/run-server #'handler {:port port})))
