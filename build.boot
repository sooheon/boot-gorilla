(def project 'sooheon/boot-gorilla)
(def version "0.1.1-SNAPSHOT")

(set-env! :resource-paths #{"src"}
          :dependencies   '[[org.clojure/clojure "1.9.0-alpha17"]
                            [boot/core "RELEASE" :scope "test"]
                            [gorilla-repl "0.4.0"]
                            [adzerk/bootlaces "0.1.13" :scope "test"]])

(task-options!
 pom {:project     project
      :version     version
      :description "start the gorilla repl"
      :url         "https://github.com/sooheon/boot-gorilla"
      :scm         {:url "https://github.com/sooheon/boot-gorilla"}
      :license     {"Eclipse Public License"
                    "http://www.eclipse.org/legal/epl-v10.html"}})

(deftask build
  "Build and install the project locally."
  []
  (comp (pom) (jar) (install)))

(require '[sooheon.boot-gorilla :refer [gorilla]]
         '[adzerk.bootlaces :refer :all])

(bootlaces! version)
