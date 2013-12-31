(ns getpid.core
  (:import (jnr.ffi LibraryLoader types.pid_t)))

(defn -main [& args]
  (def getpid
  	(-> (gen-interface :name "LibC" :methods [[getpid [] ^{jnr.ffi.pid_t true} long] [getppid [] ^{jnr.ffi.pid_t true} long]])
      LibraryLoader/create
      (.load "cygwin1")))
  (println (str "pid=" (.getpid getpid) " parent pid=" (.getppid getpid))))

