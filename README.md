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

Avoid using mutable variables in the `myFilter` function. This will likely require the creation of a recursive function.

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

6. Refactor `myFilter` to be a recursive function (further refactor required for stack safe recursion)

7. Refactor `myFilter` for stack safe recursion, using tail recursion
<br/>

------

## Solution

- Code can be found [here](https://github.com/mattTea/MyFilter-challenge6/blob/master/src/main/kotlin/MyFilter.kt)

- Tests can be found [here](https://github.com/mattTea/MyFilter-challenge6/blob/master/src/test/kotlin/MyFilterTest.kt)
<br/>

------

## To run

- Build in IntelliJ or similar IDE

- To run in a REPL, run following example commands...

```kotlin
val filter = MyFilter()

println(filter.myFilter(listOf(1, 3, 5, 7), listOf(), filter::numberIsLessThan5))
// -> [1, 3]
```

- To run for a big list, to test stack safety (WARNING, this will take a very long time)...

```kotlin
val filter = MyFilter()
val bigList : List<Int> = (0..10000000).toList()

println(filter.myFilter(bigList, listOf(), filter::numberIsLessThan5))
// -> [1, 2, 3, 4]
```

- To run tests, run `MyFilterTest` configuration in IDE
<br/>

------

## Interesting things I've learnt

#### 1. [Function types](https://kotlinlang.org/docs/reference/lambdas.html#function-types)

For declarations that deal with functions, these types have a special notation that corresponds to the signatures of the function.

i.e. their parameters and return values...
    
```kotlin
numberIsLessThan5: (Int) -> Boolean
```
<br/>

#### 2. [Generic function parameters](https://kotlinlang.org/docs/reference/generics.html#generic-functions)

```kotlin
fun <T> myFilter(list: List<T>, numberIsLessThan5: (T) -> Boolean): MutableList<T> {}
``` 
<br/>

#### 3. Predicate methods/functions

As parameters to Higher Order Functions. Reference in examples [here](https://medium.com/@JorgeCastilloPr/tail-recursion-and-how-to-use-it-in-kotlin-97353993e17f)

`numberIsLessThan5` as an example below...

```kotlin
fun <T> myFilter(list: List<T>, numberIsLessThan5: (T) -> Boolean): MutableList<T> {}
```
<br/>

#### 4. List methods

- `drop(n)` returns a list or subsequence with the first n characters removed
- `first()` returns the first element (or the first element matching a given predicate)
<br/>

#### 5. Extension methods

Created extension methods to create `tail()` and `head()` methods for Lists...

```kotlin
// drops first element in List
fun <T> List<T>.tail() = drop(1)

// returns first element in List
fun <T> List<T>.head() = first()
```
<br/>

#### 6. Tail recursion

- By looping through an iterable list and, for example, filtering it by appending a matching element to a new list at each iteration, we are managing the state inside the function ourselves.
- Ceding this responsibility to the runtime would be preferable, however, as it avoids additional complexity for the developer.

- Using a more functional approach would remove this need of managing state, as well as other side effects.
- Standard recursion allows us to leave the list state to the runtime - we don't need to create and maintain a reference to it any more.
- However, using this method with large lists risks stack overflow, as the language needs to build a call stack in order to rewind it when the last recursion is reached.
- Essentially, there are still operations to be done after the last recursion. In this case, the runtime replaces each recursion call in reverse order, from the deepest to the outer ones, with it’s resulting list of elements. When it reaches the outer most level, then it can proceed to actually call the method to build the list.

- To avoid this, we can build the list on each recursion and pass the temporary list to the next step. This means that the previous call in the stack becomes useless and could just be discarded.
- If we can achieve this for all the steps, we will reach the final recursion with the complete list already built, so there would be no need to rewind the stack, so wouldn’t actually need to maintain it. This is **`tail recursion`**.

- Using the `tailrec` keyword allows the compiler to optimise our recursive methods for complete stack safety.


See [this blog](https://medium.com/@JorgeCastilloPr/tail-recursion-and-how-to-use-it-in-kotlin-97353993e17f) for a great explanation of tail recursion in Kotlin.

