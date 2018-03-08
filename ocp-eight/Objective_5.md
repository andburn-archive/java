## 5. Parallel Streams
#### 5.1 Develop the code that use parallel streams
- by default streams are run serially
- to run a stream in parallel, use `Collection.parallelStream` or `BaseStream.parallel`
- apply intermediate and final operations as before

#### 5.2 Implement decomposition, reduction, in streams
- there are many terminal operations that *reduce* a stream to specific values
- the general purpose method is `T reduce(T identity, BinaryOperator<T> accumulator)`
  - the identity element is used to deal with edge cases, *empty lists etc.*
- the `collect` method can also be used to reduce a stream
- when reducing parallel streams it is more efficient to use methods such as
`collect(Collectors.groupingByConcurrent(...));` it returns a `ConcurrentMap`
- decomposition of the stream is achieved automatically, using the parallel methods
