# Log-linear time

In many cases, the `n log n` running time is simply the result of performing a `Θ(log n)` operation `n` times.

## Examples

* [Merge sort](https://github.com/little-pinecone/interview-coding-questions/blob/master/src/main/java/in/keepgrowing/interviewcodingquestions/algorithms/sorting/mergesort)
* [Quicksort](https://github.com/little-pinecone/interview-coding-questions/blob/master/src/main/java/in/keepgrowing/interviewcodingquestions/algorithms/sorting/quicksort)
* `Binary tree sort` creates a binary tree by inserting each element of the n-sized array one by one. Since the insert
  operation on a self-balancing binary search tree takes `O(log n)` time, the entire algorithm takes `O(n log n)`
  time.

## References

* [Wikipedia](https://en.wikipedia.org/wiki/Time_complexity#Quasilinear_time)