## 4. Collection Operations with Lambda
#### 4.1 Develop the code to extract data from an object using map
- `Stream.map` takes a `Function`
- primitive streams exists for specific tasks `IntStream ...`
- `Stream.max` and `Stream.min` exist, but `Stream.average` and `Stream.sum` do not
- primitive types generally use `Stream.mapToInt` to convert to primitive streams

#### 4.2 Search for data using search methods including: *findFirst, findAny, anyMatch, allMatch, noneMatch.*
- `findFirst` if source is ordered, returns first as `Optional`
- `findAny` finds any filtered element, as `Optional`
- `anyMatch` takes a `Predicate` and is true if any element matches
- `allMatch` if a `Predicate` matches all elements
- `noneMatch` no element matches the `Predicate`

#### 4.3 Describe the unique characteristics of the Optional classes
- `java.util.Optional<T>` may or may not be null
- `isPresent()` tells if a value is present, can also take a `Consumer` param to execute if present
- `get()` returns the value, also `getOrElse(T t)` to give a default value

#### 4.4 Perform calculations using methods: count, max, min, average, sum
- `Stream.min` and `max` take `Comparator`'s
```java
String shortest = items.stream()
    .min(Comparator.comparing(String::length))
    .get();
```
- `average` and `sum` only on primitive types

#### 4.5 Sort a collection using lambda expressions
- for a `Stream` of `Comparable` elements, `sorted()` sorts the elements in natural order
- can use `sorted` with a `Comparator` to custom sort with `comparing(Function<T,U> f)` to create a sort key
```java
List<Animals> zoo = items
    .sorted(Comparator.comparing(e -> e.name.length()))
    .collect(Collectors.toList())
```
- with two or more `Comparators` can be chained as `sorted(c1.thenComparing(c2))`

#### 4.6 Save results to a collection by using the collect method and Collector class; including methods such as: *averagingDouble, groupingBy, joining, partitioningBy*
- `Stream.collect` takes three arguments
  - a supplier `Supplier` to make new instances of the target object
  - an accumulator `BiConsumer` that adds an element to the target
  - and a combiner `BinaryOperator` that merges two objects into one
- `Collectors` class provides static methods to create common `Collector`'s
  - `Collectors.averagingDouble(ToDoubleFunction<T> mapper)` average as a double
  - `Collectors.groupingBy(Function<T, K> classifier)` groups elements according to the function
  - `Collectors.joining()` combines all elements using `toString()`, overloaded version takes separator argument
  - `Collectors.partitioningBy(Predicate<T> predicate)` splits the stream into two lists, either true or false
