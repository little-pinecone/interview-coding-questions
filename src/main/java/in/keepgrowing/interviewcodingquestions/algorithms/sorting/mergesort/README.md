# Merge sort

A [stable](https://simple.wikipedia.org/wiki/Stable_sorting_algorithm),
[divide and conquer](https://simple.wikipedia.org/wiki/Divide_and_conquer_algorithm)
algorithm for sorting a list of items.

With merge sort, dividing lists is trivial, and merging them together isn't. It's also highly parallelizable. It can be
used for solving the inversion counting problem.

## Steps

* If the list contains only one item, then return the list
* Divide the list into two lists of half the size of the list
* Apply the algorithm to each of the two lists until each sublist contains only one element and is, by definition,
  sorted
* Merge the sublists together sorting as it goes

Worst-case time complexity: `O(n log(n))`.

## References

* [Wikipedia](https://simple.wikipedia.org/wiki/Merge_sort)