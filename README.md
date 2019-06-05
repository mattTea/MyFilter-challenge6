MyFilter
========

Solution to the JL [coding challenge #06](https://coding-challenges.jl-engineering.net/challenges/challenge-6/) using Kotlin & JUnit5
<br/>

------

## Problem description

Create a filter method called `myFilter`.

It should take an array of integers as its first parameter and a function as its second parameter.

The function passed as a parameter accepts an integer as a parameter and returns a boolean value (true or false).

The `myFilter` function applies the function passed to it to each element in the input array and only includes elements in the output array if the result is true.


The use of Higher Order Functions such as `Map`, `Filter`, `Reduce` or `Fold` built into the programming language you use is not allowed.

To make this harder, avoid using mutable variables in the `myFilter` function which will probably require you to create a recursive function.
<br/>

------

## Motivation

Focus (for me) is on test-driving the solution and some functional programming concepts within Kotlin (e.g. higher order functions, function types)
<br/>

------

## Problem breakdown

1. `numberIsLessThan5` returns `true` for a number less than 5

2. `numberIsLessThan5` returns `false` for number 5

3. `myFilter` returns hard-coded single item `Array<Int>`

4. `myFilter` returns hard-coded multiple item `Array<Int>`

5. `myFilter` returns filtered `List<Int>` (still with mutable variables inside function) 

6. Remove mutable variables from `myFilter`
<br/>

------

## To run tests

- Build in IntelliJ or similar IDE

- Run `MyFilterTest` configuration to run test
<br/>

------

## Interesting things I've learnt

#### [Function types](https://kotlinlang.org/docs/reference/lambdas.html#function-types)

For declarations that deal with functions, these types have a special notation that corresponds to the signatures of the function.

i.e. their parameters and return values...
    
```kotlin
numberIsLessThan5: (Int) -> Boolean
```
<br/>

#### [Generic function parameters](https://kotlinlang.org/docs/reference/generics.html#generic-functions)

```kotlin
fun <T> myFilter(list: List<T>, numberIsLessThan5: (T) -> Boolean): MutableList<T> {}
``` 
<br/>

#### Predicate methods/functions

As parameters to Higher Order Functions. Reference in examples [here](https://medium.com/@JorgeCastilloPr/tail-recursion-and-how-to-use-it-in-kotlin-97353993e17f)

`numberIsLessThan5` as an example below...

```kotlin
fun <T> myFilter(list: List<T>, numberIsLessThan5: (T) -> Boolean): MutableList<T> {}
```

