(ns sooheon.boot-gorilla
  "Boot the gorilla repl"
  {:boot/export-tasks true}
  (:require [boot.core :as boot :refer [deftask]]))

(def gorilla-version "0.4.1-SNAPSHOT")

(deftask gorilla
  "Start the gorilla-repl server"
  [p port       PORT int "The port to run the web REPL on. Defaults to 4000."
   i ip         IP   str "The IP address the server listens on. Defaults to 127.0.0.1"
   n nrepl-port PORT int "The port that the nREPL server will be started up on. Defaults to a free port."
   b block           bool "Blocking (for standalone use)"]
  (let [env          (boot.pod/make-pod (boot/get-env))
        port         (or port 4000)
        ip           (or ip "127.0.0.1")
        nrepl-port   (or nrepl-port 0)
        project-name (or (:project env) "a standalone project")
        block        (or block true)]
    (comp
     (boot/with-pre-wrap fileset
       (boot.pod/with-eval-in env
         (boot.pod/add-dependencies
          (assoc boot.pod/env :depenencies '[[sooheon/gorilla-repl ~gorilla-version]]))
         (require '[gorilla-repl.core :as g])
         (g/run-gorilla-server {:port       ~port
                                :ip         ~ip
                                :nrepl-port ~nrepl-port
                                :version    ~gorilla-version
                                :project    ~project-name})
         (boot.util/info "<< started Gorilla REPL on http://%s:%d >>\n" ~ip ~port))
       fileset)
     (if block
       (boot.task.built-in/wait)
       identity))))
