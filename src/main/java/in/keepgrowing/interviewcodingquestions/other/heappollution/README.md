# Heap pollution

In Java, heap pollution is a situation that arises when a variable of a parameterized type refers to an object that is
not of that parameterized type. During runtime heap pollution will often cause a ClassCastException.

To avoid this problem, we shouldn't use generic types without type parameters.

From the **Raw types should not be used** SonarQube rule:

Generic types shouldn’t be used raw (without type parameters) in variable declarations or return values. Doing so
bypasses generic type checking, and defers the catch of unsafe code to runtime.

**Noncompliant** Code Example

`List myList;`

**Compliant** Solution

`List<String> myList;`

## References

* [Wikipedia](https://en.wikipedia.org/wiki/Heap_pollution)