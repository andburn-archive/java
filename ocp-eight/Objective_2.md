## 2. Using Built in Lambda Types
#### 2.1 Describe the built in interfaces included in Java 8
- `java.util.function` contains the built-in functional interfaces for use with lambda expressions
- there are over 40 different interfaces that can be grouped into 4 basic *shapes*:
  - **Function&lt;T,R&gt;** takes an argument and returns a result `T -> R`
  - **Consumer&lt;T&gt;** takes an argument and returns nothing `T -> void`
  - **Supplier&lt;T&gt;** takes no arguments and returns a result `() -> T`
  - **Predicate&lt;T&gt;** takes an argument and returns a boolean `T -> bool`
- many of the interfaces in the package offer variations to allow the use of primitive types as arguments and/or results: `DoubleConsumer`, `DoubleToIntFunction`, `BooleanSupplier`, `ToDoubleFunction`
- other specializations include adding...
  - **BiFunction<T,U,R>** a function that takes two arguments `(T,U) -> R`
  - **UnaryOperator<T>** is a function that takes one argument and returns a result of the same type `T -> T`
  - **BinaryOperator<T,T>** is a bi-function where args and return type are the same `(T,T) -> T`

#### 2.2 Develop code that uses Function interface
- it is used in cases where a value is processed and result is produced
- the base class has the abstract method `R apply(T t)`
```java
Function<String, Boolean> f = s -> new Boolean(s);
boolean b = f.apply("a string");
```
- `Function<T,V> andThen(Function<? super R,? extends V> after)`
- `Function<V,R> compose(Function<? super V,? extends T> before)`

#### 2.3 Develop code that uses Consumer interface
- is used when a value is to be used internally and no result produced
- the abstract method is `void accept(T t)`
```java
Consumer<String> c = s -> System.out.println(s);
c.accept("a string");
```
- `Consumer<T> andThen(Consumer<? super T> after)`


#### 2.4 Develop code that uses Supplier interface
- is used when a value is required based on no input
- the abstract method is `T get()`
```java
Supplier<String> s = () -> "Some Text";
String a = s.get();
```

#### 2.5 Develop code that uses UnaryOperator interface
- specialization of Function, `extends Function<T,T>`
- argument and return type are the same
- abstract method inherited, `T apply(T t)`
```java
UnaryOperator o = s -> "string" + s;
String s = o.apply(" more strings");
```

#### 2.6 Develop code that uses Predicate interface
- is used when a value is to be tested and a boolean is returned
- the abstract method is `boolean test(T t)`
```java
Predicate<String> p = (s) -> s == "test value";
boolean b = p.test("to be tested");
```
- short circuit AND `Predicate<T> and(Predicate<? super T> other)`
- short circuit OR `Predicate<T> or(Predicate<? super T> other)`
- and negation `Predicate<T> negate())`

#### 2.7 Develop the code that use primitive and binary variations of base interfaces of java.util.function package
- to avoid boxing and unboxing of primitive types to/from wrapper objects, there are many primitive versions of the aforementioned functional interfaces
- `Predicate<Integer> pi = i -> i > 0;` would involve boxing
- `IntPredicate ip = i -> i > 0;` would not
- for the base types we have `Int, Long, Double` prefixes
- `Supplier` also has `Boolean`
- `Function` allows for primitive output as well as input adding *To* prefixes `ToIntFunction<T>, LongToIntFunction, ...`
- the base versions also have binary versions, to accommodate specialized use cases (*nothing for supplier*)
  - **BinaryOperator&lt;T>** `(T,T) -> T`
  - **BiPredicate&lt;T,U>** `(T,U) -> boolean`
  - **BiConsumer&lt;T,U>** `(T,U) -> void`
  - **BiFunction&lt;T,U, R>** `(T,U) -> R`

#### 2.8 Develop the code that use method reference; including refactor the code that use Lambda expression to use method references
- a method reference is a way of writing specific types of lambdas, those in which a method is referenced directly
- there are four types of method references:
  1. static methods
  ```java
  UnaryOperator<String> uo = (String s) -> s.toUpperCase();
  UnaryOperator<String> uo = String::toUpperCase;
  ```
  2. constructors
  ```java
  Function<StringBuffer, String> f = sb -> new String(sb);
  Function<StringBuffer, String> f = String::new;
  ```
  3. instance methods on an arbitrary object
    - the first parameter becomes the target of the method, subsequent parameters as arguments
  ```java
  UnaryOperator<String> uo = s -> s.trim();
  UnaryOperator<String> uo = String::trim;
  ```

  4. instance methods on a specific object
    - when a specific existing object is to be used a the target object
  ```java
  String v = "a value";
  Predicate<String> p = s -> v.equalsIgnoreCase(s);
  Predicate<String> p = v::equalsIgnoreCase;
  ```
