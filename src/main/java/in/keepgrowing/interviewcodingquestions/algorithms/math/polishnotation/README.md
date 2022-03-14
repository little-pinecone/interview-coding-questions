# Polish notation

Polish prefix notation or simply prefix notation, is a mathematical notation in which operators precede their operands,
in contrast to the more common infix notation, in which operators are placed between operands, as well as reverse Polish
notation (RPN), in which operators follow their operands. It does not need any parentheses as long as each operator has
a fixed number of operands.

## Infix-Postfix Conversion

While there are elements to be read, read an element and if it is:

- an operand – add it to the `output`
- an operator
    - if the precedence of the operator in the `head` of the `operator stack` is greater than or equal to its precedence
      – pop elements from `operator stack` to the `output`, only then add the operator to the stack
    - if its precedence is greater, or it is an opening parenthesis – push it to the `operator stack`
    - if it is a closing parenthesis – pop elements from the `operator stack` to the `output` until you encounter an
      opening parenthesis, discard the opening parenthesis; if there is no opening parenthesis then there are mismatched
      parentheses

While there are operators on the `operator stack`:

- if `operator stack` contains an opening parenthesis, then there are mismatched parentheses
- pop the operators from the `operator stack` to the `output`

:no_entry: The example implementation does not take into account operator associativity! Therefore, in some cases the
conversion may not produce correct results.

## References

* [Wikipedia Polish notation](https://en.wikipedia.org/wiki/Polish_notation)
* [Wikipedia Reverse Polish notation](https://en.wikipedia.org/wiki/Reverse_Polish_notation)
* [Wikipedia Shunting-yard algorithm](https://en.wikipedia.org/wiki/Shunting-yard_algorithm)
* [Infix to postfix and prefix online converter](https://raj457036.github.io/Simple-Tools/prefixAndPostfixConvertor.html)
* [Convert Infix to Prefix Expression](https://algorithms.tutorialhorizon.com/convert-infix-to-prefix-expression/)