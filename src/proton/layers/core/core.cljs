(ns proton.layers.core.core
  (:use [proton.layers.base :only [get-keybindings get-packages get-keymaps]]))

(defn get-active-pane [atom]
  (.getView (.-views atom) (.getActivePane (.-workspace atom))))

(defmethod get-keybindings :core
  []
  {
    :0 {:action "tree-view:toggle-focus"}
    :j {:action "window:focus-pane-below"
        :target get-active-pane}
    :k {:action "window:focus-pane-above"
        :target get-active-pane}
    :l {:action "window:focus-pane-on-right"
        :target get-active-pane}
    :h {:action "window:focus-pane-on-left"
        :target get-active-pane}
    :w {:category "window"
        :m {:action "maximise"}
        :d {:action "pane:close"
            :target get-active-pane}
        :v {:action "pane:split-right"
            :target get-active-pane}
        :h {:action "pane:split-down"
            :target get-active-pane}
        :V {:action "pane:split-left"
            :target get-active-pane}
        :H {:action "pane:split-up"
            :target get-active-pane}
        :| {:action "pane:split-right"
            :target get-active-pane}
        :/ {:action "pane:split-right"
            :target get-active-pane}
        :- {:action "pane:split-down"
            :target get-active-pane}}
   :b {:category "buffer"
        :m {:action "maximise"}
        :b {:action "fuzzy-finder:toggle-buffer-finder"}
        :K {:action "pane:close-other-items"
            :target get-active-pane}
        :d {:action "pane:close"
             :target get-active-pane}}
   :p {:category "project"
       :t {:action "tree-view:toggle"}
       :f {:action "fuzzy-finder:toggle-file-finder"}}})

(defmethod get-keymaps :core
  []
  [{:selector ".tree-view" :keymap [["escape" "tree-view:toggle"]]}
   {:selector "body" :keymap [["ctrl-j" "core:move-down"]
                              ["ctrl-k" "core:move-up"]]}
   {:selector "atom-text-editor" :keymap [["ctrl-k" "core:move-up"]
                                          ["ctrl-j" "core:move-down"]]}])

(defmethod get-packages :core
  []
  ;; most of these packages are atom defaults
  ;; adding them here so proton doesn't remove them by accident
  [:proton
   :vim-mode
   :ex-mode

   :atom-dark-syntax
   :atom-dark-ui
   :atom-light-syntax
   :atom-light-ui
   :base16-tomorrow-dark-theme
   :base16-tomorrow-light-theme
   :one-dark-ui
   :one-dark-syntax
   :one-light-syntax
   :one-light-ui
   :solarized-dark-syntax
   :solarized-light-syntax
   :about
   :archive-view
   :autocomplete-atom-api
   :autocomplete-css
   :autocomplete-html
   :autocomplete-plus
   :autocomplete-snippets
   :autoflow
   :autosave
   :background-tips
   :bookmarks
   :bracket-matcher
   :command-palette
   :deprecation-cop
   :dev-live-reload
   :encoding-selector
   :exception-reporting
   :find-and-replace
   :fuzzy-finder
   :git-diff
   :go-to-line
   :grammar-selector
   :image-view
   :incompatible-packages
   :keybinding-resolver
   :line-ending-selector
   :link
   :markdown-preview
   :metrics
   :notifications
   :open-on-github
   :package-generator
   :release-notes
   :settings-view
   :snippets
   :spell-check
   :status-bar
   :styleguide
   :symbols-view
   :tabs
   :timecop
   :tree-view
   :update-package-dependencies
   :welcome
   :whitespace
   :wrap-guide
   :language-c
   :language-clojure
   :language-coffee-script
   :language-csharp
   :language-css
   :language-gfm
   :language-git
   :language-go
   :language-html
   :language-hyperlink
   :language-java
   :language-javascript
   :language-json
   :language-less
   :language-make
   :language-mustache
   :language-objective-c
   :language-perl
   :language-php
   :language-property-list
   :language-python
   :language-ruby
   :language-ruby-on-rails
   :language-sass
   :language-shellscript
   :language-source
   :language-sql
   :language-text
   :language-todo
   :language-toml
   :language-xml
   :language-yaml])
