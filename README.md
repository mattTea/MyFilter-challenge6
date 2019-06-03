MyFilter
========

Solution to the JL coding challenge #06 using Kotlin & JUnit5

------

## Problem description

Create a filter method called `myFilter`.

It should take an array of integers as its first parameter and a function as its second parameter.

The function passed as a parameter accepts an integer as a parameter and returns a boolean value (true or false).

The `myFilter` function applies the function passed to it to each element in the input array and only includes elements in the output array if the result is true.


The use of Higher Order Functions such as `Map`, `Filter`, `Reduce` or `Fold` built into the programming language you use is not allowed.

To make this harder, avoid using mutable variables in the `myFilter` function which will probably require you to create a recursive function.


------

### Example output in ES6

```Javascript
const numberIsLessThan5 = (aNumber) => {return aNumber < 5 }; //this is the function to filter out values less than 5
const result = myFilter([3,4,5,6,7,8], (numberIsLessThan5)); 
console.log(result); //this should print out [3,4]

```

------

## Motivation

Focus (for me) is on test-driving the solution, and Single Responsibility Principle (including isolating classes under test).

------

## Problem breakdown

1. `myFilter` returns hard-coded `Array<Int>`

2. 

