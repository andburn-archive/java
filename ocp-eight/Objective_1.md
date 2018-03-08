## 1. Lambda Expressions
#### 1.1 Describe Java inner classes and develop the code that uses Java inner classes
- **nested**
  - defined inside an *outer* class, cannot have any static declarations
  - has to be associated with an *outer* instance
  - defined normally in the within the outer class, from another class need to use `Outer.Inner inn = new Outer().new Inner();`
  - within the inner class `this` references the inner instance, and `OuterClassName.this` references the outer class instance
  - like a regular member of a class, inner class can be `final, abstract, public, private, protected, strictfp, static*`
- **static**
  - is not really an inner class, but a static member of the outer class
  - accessed in the same way as other static members, without an outer class instance
  - to access the class outside use `Outer.Inner si = new Outer.Inner();`
  - note that in the static inner class can only access static members of the outer class
- **local**
  - defined inside a method, and can only be instantiated within that method, and only after it has been declared
  - can access all outer class members, but not local variables of declaring method unless they are `final`
    - in Java 8, locals can now be *effectively final* if they are not changed from their initialization
  - if declaring method is `static` only outer `static` members are available
  - class modifiers only either `final` or `abstact`
- **anonymous**
  - creates "on the fly" instance of a subclass of a class, or implementing instance of an interface.
  - can occur even as an argument to a method.
  ```java
  obj.stuff(new Foo() {
      public String get() { return "done"; }
  });
  ```
  - anonymous class can only override methods defined in the *super class*, that is the reference type `Foo f = new Foo() {...}`

#### 1.2 Define and write functional interfaces
- a *functional interface* is a specific form of interface in Java 8, for use with lambda expressions
- it contains only a single abstract function, the *functional method*
- remember methods in an interface are `public abstract` whether they are defined as such or not
- the new annotation `@FunctionalInterface` is used to mark such an interface, it is optional but when used checks the interface has one and only one abstract method
- this now applies to previous single method interfaces in previous versions such as `Runnable, Comparator`
- Java 8 now allows interfaces to contain `default` and `static` methods as well as `abstract`, they are still implicitly public
- `default` methods are inherited by implementing classes and can be overridden
- `static` methods belong to the interface, and are therefore invoked with the interface name and not the implementing classes name `Animal.fetch()`

#### 1.3  Describe a Lambda expression; refactor the code that use anonymous inner class to use Lambda expression; including type inference, target typing
- a way to simplify the use of anonymous classes implementing interfaces
- implement a functional interface as an anonymous class
```java
(String s) -> System.out.println("do stuff with " + s);
```
- params need to match params of the functional method
- if no params use empty parentheses
- type inference is used so argument type can be optional `(s) -> ...`
  - further, with inference parentheses can also be removed `s -> ...`, they are necessary if using type, only for single param
  - if use type for one param need to use for all

- the right hand side is returned as the value
  - careful with this as method may not return what you think, `boolean` for example
  - can use a block rather than single statement, can return within a block
  ```java
  () -> {
      int a = 32;
      return a * 3;
  };
  ```
  - block must terminate with semi-colon
- *target typing* is the process by which the complier determines the *type* of a lambda expression
- there can be ambiguity when a lambda expression is used as a method argument, the type declared in the method params is the target type
- therefore, lambdas can only be used where the target type can be determined:
  - Variable declarations
  - Assignments
  - Return statements
  - Array initializers
  - Method or constructor arguments
  - Lambda expression bodies
  - Conditional expressions
  - Cast expressions
