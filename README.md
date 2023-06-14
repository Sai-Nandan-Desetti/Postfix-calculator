# Postfix-calculator

## How to use the calculator?
If you clone this repository, then in the `Postfix-calculator` directory run (in Windows)
```
java main\TestCalc.java
```

(If it runs successfully) You will see the prompt:
```
Enter the post-fix expression:
```

Your input should have each symbol separated by a space.

Eg:
```
Enter the post-fix expression: 2 3 +

The result: 5.0

Enter the post-fix expression: 
```

You will be prompted for another expression. And it will continue until you type "done" (case insensitive).
```
Enter the post-fix expression: done
```

Operators supported: +, -, *, /, ^

## Logic:
* The calculator's evaluation logic is implemented in the `evaluate()` method of `PfCalculator.java`:
    * Input: A `Queue`.
    * Remove each element from the input queue one at a time and push it to a `Stack`
    If the element is recognized as an operator, pop 2 string values off of the `Stack`, convert them to their numeric equivalents, perform the calculation with those values, and push the result (as a string) back onto the `Stack`. Otherwise, simply push the token onto the stack. When the input queue is empty, then pop the stack for the result and return it.

