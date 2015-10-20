# to-html-converter

1) How it works:

POST method's body contains text, formatted like below

- Lines starting with #, ##, ### etc. become headers <h1/>, <h2/>, <h3/> etc.

- Simple lines become paragraphs (just a line –> <p>just a line</p>)

- Text wrapped in *...* becomes emphasized (*lorem* –> <em>lorem</em>)

- Text wrapped in **...** becomes strong (**lorem** –> <strong>lorem</strong>)

- Links support ([example link](http://example.com/) –> <a href=“http://example.com/”>example link</a>)

- Other than that, no transformation should happen to text

2) In order to save POST method's body, method should contain such header "save: true".