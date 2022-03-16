# Factorial

The factorial of a whole number n, written as n! or n, is found by multiplying n by all the whole numbers less
than it. For example, the factorial of 4 is 24, because 4 × 3 × 2 × 1 = 24. Hence one can write 4! = 24. For some
technical reasons, 0! is equal to 1.

Factorial can be used to find out how many possible ways there are to arrange n objects.

For example, if there are 3 letters (A, B, and C), they can be arranged as ABC, ACB, BAC, BCA, CAB, and CBA. That would
be 6 choices because A can be put in 3 different places, B has 2 choices left after A is placed, and C has only one
choice left after A and B have been placed. In other words, 3 × 2 × 1 = 6 choices.

The factorial function is a good example of recursion (doing things over and over), as 3! can be written as 3×(2!),
which can be written as 3×2×(1!) and finally as 3×2×1×(0!). N! can therefore also be defined as N×(N-1)!, with 0! =
1.[3]

The factorial function grows very fast. There are 10! = 3,628,800 ways to arrange 10 items.

## References

* [Wikipedia](https://simple.wikipedia.org/wiki/Factorial))