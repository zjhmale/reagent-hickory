# reagent-hickory

[![Build Status](https://travis-ci.org/zjhmale/reagent-hickory.svg?branch=master)](https://travis-ci.org/zjhmale/reagent-hickory)

an enhancement of using hickory to generate reagent style hiccup

## Installation

[![Clojars Project](https://img.shields.io/clojars/v/zjhmale/reagent-hickory.svg)](https://clojars.org/zjhmale/reagent-hickory)

## Usage

```clojure
(:require-macros [reagent-hickory.templates :refer [deftemplate]])
(:require [reagent-hickory.sweet :refer [html->hiccup]])
```

* convert from html string

```clojure
user=> (html->hiccup "<p class='someclass'><span>I have </span><strong>bold</strong><span style='color:red'> and red </span><span>text.</span></p>")
[:p {:class "someclass"} [:span {} "I have "] [:strong {} "bold"] [:span {:style {"color" "red"}} " and red "] [:span {} "text."]]
```

* convert from html file

put you html file in `resources/public/templates/`

```clojure
user=> (deftemplate component "component.html") ;;#'component can put in any reagent capatible hiccup structure
user=> component
[:p {:class "someclass"} [:span {} "I have "] [:strong {} "bold"] [:span {:style {"color" "red"}} " and red "] [:span {} "text."]]
```

## License

Copyright © 2016 zjhmale

Distributed under the Eclipse Public License, the same as Clojure.
