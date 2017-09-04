## 6. Lambda Cookbook
#### 6.1 Develop the code that use Java SE 8 collection improvements: Colleciton.removeIf, List.replaceAll, Map.computeIfAbsent/Present, Map.forEach
- `boolean removeIf(Predicate<E> filter)` remove elements of the collection if they satisfy the `Predicate`, it returns true if any elements are removed
- `void replaceAll(UnaryOperator<E> operator)` replaces all elements of the list with the result of the operator
- `V computeIfAbsent(K key, Function<K,V> mappingFunction)` if the key is absent compute the value and add it to map if not null (returns new value)
- `V computeIfPresent(K key, BiFunction<K,V,V> remappingFunction)` if the key  exists computes a new mapping
- `void forEach(BiConsumer<K, V> action)` performs the action on all elements

#### 6.2 Read files using lambda improvements: Files.find, lines(), walk()
- `java.nio.file.Files`

```java
static Stream<Path> find(Path start,
    int maxDepth,
    BiPredicate<Path,BasicFileAttributes> matcher,
    FileVisitOption... options) throws IOException
```
- finds all files that match the predicate

```java
static Stream<String> lines(Path path) throws IOException
```
- reads all lines from path into a stream


```java
static Stream<Path> walk(Path start, FileVisitOption... options)
```
- lazy populated with files in the tree from start


- `Stream` is `AutoCloseable` so can be used as try-with-resources

#### 6.3 Use merge, flatMap methods on a collection
- applying functions to a stream

`Stream<R> flatMap(Function<? super T,? extends Stream<? extends R>> mapper)`

`Stream<R> map(Function<? super T,? extends R> mapper)`


#### 6.4 Describe other stream sources: Arrays.stream(), IntStream.range()
- many `Arrays` stream methods for generic and primitive
- `static <T> Stream<T> stream(T[] array)`
- an ordered `IntStream`
- `static IntStream range(int startInclusive, int endExclusive)`
