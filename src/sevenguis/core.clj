(ns sevenguis.core
  (:import (com.formdev.flatlaf FlatDarkLaf)))
(use 'clojure.repl)
(use 'seesaw.core)
(use 'seesaw.dev)




(defn display [title create-content-fn & args]
  (invoke-later
    (FlatDarkLaf/install) ; FIRST install LAF -then create content: (content)
    (let [main-frame (frame :title title :on-close :dispose)]
       (config! main-frame :content (if (seq args) (apply create-content-fn args)(create-content-fn)))
       (pack! main-frame)
       (show! main-frame)
       (println main-frame))))
