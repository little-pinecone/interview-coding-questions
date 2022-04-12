# interview-coding-questions

[![keep growing logo](readme-images/logo_250x60.png)](https://keepgrowing.in)

Code examples solving common interview questions.

This repository is based on the work done in
the [trekhleb/javascript-algorithms](https://github.com/trekhleb/javascript-algorithms)
project, but presents example implementations in Java.

This project is meant to be used for **learning and researching purposes only**.

## Getting Started

[Clone](https://docs.github.com/en/github/creating-cloning-and-archiving-repositories/cloning-a-repository-from-github/cloning-a-repository)
this repository.

### Running tests

Run unit tests with the following command in the project directory:

```shell
mvn test
```

You can examine test cases in
the [test](https://github.com/little-pinecone/interview-coding-questions/tree/master/src/test/java/in/keepgrowing/interviewcodingquestions)
folder

## Algorithms

### Math

* [Splitting mathematical operation into list of operators and operands](src/main/java/in/keepgrowing/interviewcodingquestions/algorithms/math/other/MathExpressionSplitter.java)
* [Fibonacci number](src/main/java/in/keepgrowing/interviewcodingquestions/algorithms/math/fibonacci)
* [Polish notation](src/main/java/in/keepgrowing/interviewcodingquestions/algorithms/math/polishnotation)
* [Factorial calculator](src/main/java/in/keepgrowing/interviewcodingquestions/algorithms/math/factorial)
* [Prime numbers](src/main/java/in/keepgrowing/interviewcodingquestions/algorithms/math/primenumbers)
* [Greatest common divisor](src/main/java/in/keepgrowing/interviewcodingquestions/algorithms/math/greatestcommondivisor)
* [Least common multiple](src/main/java/in/keepgrowing/interviewcodingquestions/algorithms/math/leastcommonmultiple)

### Sorting

* [Merge sort](src/main/java/in/keepgrowing/interviewcodingquestions/algorithms/sorting/mergesort)
* [Quicksort](src/main/java/in/keepgrowing/interviewcodingquestions/algorithms/sorting/quicksort)
* [With Java Comparators](src/main/java/in/keepgrowing/interviewcodingquestions/algorithms/sorting/withcomparators)
* [Insertion sort](src/main/java/in/keepgrowing/interviewcodingquestions/algorithms/sorting/insertionsort)

### Search

* [Binary search](src/main/java/in/keepgrowing/interviewcodingquestions/algorithms/search/binarysearch)

### String

* [Palindrome](src/main/java/in/keepgrowing/interviewcodingquestions/algorithms/string/palindrome)

## Data structures

* [Stack](src/main/java/in/keepgrowing/interviewcodingquestions/datastructures/stack)
* [Queue](src/main/java/in/keepgrowing/interviewcodingquestions/datastructures/queue)

## Other

* [Heap pollution](src/main/java/in/keepgrowing/interviewcodingquestions/other/heappollution)

### Time complexity

* [Constant O(1)](src/main/java/in/keepgrowing/interviewcodingquestions/other/timecomplexity/constanttime)
* [Logarithmic O(log n)](src/main/java/in/keepgrowing/interviewcodingquestions/other/timecomplexity/logarithmictime)
* [Linear O(n)](src/main/java/in/keepgrowing/interviewcodingquestions/other/timecomplexity/lineartime)
* [Log-linear O(n log n)](src/main/java/in/keepgrowing/interviewcodingquestions/other/timecomplexity/loglineartime)
* [Quadratic O(n^2)](src/main/java/in/keepgrowing/interviewcodingquestions/other/timecomplexity/quadratictime)

---

**Built With**

* [Java 17](https://keepgrowing.in/java/how-to-install-openjdk-17-on-ubuntu/)
* [Junit5](https://junit.org/junit5/docs/current/user-guide/#overview)