(ns getlogin.core
  (:import jnr.ffi.LibraryLoader))

(defn -main [& args]
  (def getlogin
  	(-> (gen-interface :name "LibC" :methods [[getlogin [] String]])
      LibraryLoader/create
      (.load "cygwin1")))
  (println (str "login=" (.getlogin getlogin))))
