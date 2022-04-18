# Insertion sort

A method of sorting data, such as numbers, one item at a time. It is not a very efficient method compared to other
algorithms such as quicksort. However, it is a very simple algorithm that is easy to build.

Useful when `n` is guaranteed to be small, and when we need a stable sort.

## Steps

* Work left to right, examine each item and compare it to elements on its left
* Insert the item in the correct position in the array if a smaller element on its left has been found

Time complexity: `O(n^2)`.

## References

* [Wikipedia](https://simple.wikipedia.org/wiki/Insertion_sort)