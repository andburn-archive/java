## 3. Filtering Collections with Lambdas
#### 3.1 Develop the code that iterates a collection by using `forEach`, including method chaining
- the `Iterable` class used in Java 6/7 in conjunction with the *foreach* loop was used to iterate over a *Collection* or *Map*
- for Java 8 `Iterable` now contains a default `forEach` method, taking a functional interface as an argument
- `Collection` implements `Iterable` taking a `Consumer`, and `Map` is given its own `forEach` taking a `BiConsumer`
- this new way of iterating a collection makes the actual iteration passive, applying an operation to each element, `forEach` is `void` nothing is returned
```java
ArrayList<String> list = new ArrayList<>();
list.forEach(System.out::println);
```
- multiple methods can be applied to the iteration by chaining the lambdas
```java
Consumer<String> c1 = String::toUpperCase;
Consumer<String> c2 = System.out::println;
list.forEach(c1.andThen(c2));
```

#### 3.2 Describe the Stream interface and pipelines
- a stream is a sequence of elements from some source `array` or `Collection`
- it does not hold any data, but facilitates aggregate operations upon it
- two types of operations act on a stream, intermediate and final
- intermediate operations return streams and do not perform any computation until a final operation is called, examples `filter, map`
  - `Stream<T> filter(Predicate<T> p)` use the predicate to select which elements are to be included
  - `Stream<R> map(Function<T, R> map)` maps the stream elements according to a function to a stream of the same size
  - `Stream<T> distinct()` returns a stream of distinct elements, no repetition according to `Object.equals`
  - `Stream<T> peek(Consumer<T> action)` used mainly to view elements as they flow through the pipeline, similar to `forEach` but not final
- final or terminal operations consume a stream possibly returning a result, but never a `Stream`
- **once a terminal operation is applied to a stream that stream can no longer be used**
  - `R collect(Collector<T,A,R> collector)` collect is used to group a stream into another format such as a `Collection`
    - built in `Collector`s can be found in `Collectors` class
    ```java
    list.stream().filter(p).collect(Collectors.toList());
    ```
  - `Optional<T> max(Comparator<T> comparator)` and also min, gets the result on the stream according to the `Comparator`
    - the new `Comparator.comparing()` method takes a lambda function to define the sort order
    ```java
    Comparator<Person> cmpr = Comparator.comparing(Person::getLastName);
    ```
    - max returns an `Optional` which caters for the case when no result is possible use `Optional.get()` to get the value, maybe `null`
  - `Optional<T> findAny()`
  - `Optional<T> findFirst();`
  - `long count()`
- the steam pipeline is the combination of the source, intermediary operations and the final operation

#### 3.3 Filter a collection using lambda expressions
- filter takes a predicate and includes elements passing the test
```java
ArrayList<String> list = new ArrayList<>();
list.stream().filter(e -> e.equalsIgnoreCase("string")).collect(Collectors.toList());
```

#### 3.4 Identify lambda operations that are lazy
- intermediate operations are lazy
