# Quick sort

An [unstable](https://simple.wikipedia.org/wiki/Stable_sorting_algorithm),
[divide and conquer](https://simple.wikipedia.org/wiki/Divide_and_conquer_algorithm)
algorithm that splits the array into two parts, and then continues to split those parts into more parts, using
comparison sort along the way.

Efficient for large data sets. Performance depends on pivot selection.

With quicksort, dividing lists is more complex than with merge sort, but the merging step is trivial.

## Steps

* If there is only one item in the array, or no items, stop because we don't need to sort anything.
* Pick any item in the array, this will now be the pivot point.
* Partition the items. Compare each item to the pivot. If it is smaller than the pivot it should come before the pivot
  in the array, if it is larger it should come after the pivot. Note that our pivot is now in its sorted position.
* Recursively apply the algorithm to all items left of the pivot (excluding the current pivot)
* Recursively apply the algorithm to all items right of the pivot (excluding the current pivot)

Time complexity: `O(n log n )` (guaranteed by random pivot selection), `O(n^2)` (worst).

## References

* [Wikipedia](https://simple.wikipedia.org/wiki/Quicksort)
* [StackOverflow](https://stackoverflow.com/a/39407750)
* [GeeksForGeeks](https://www.geeksforgeeks.org/quick-sort/)