## 7. Method Enhancements
#### 7.1 Adding static methods to interfaces
- interfaces can now define static methods
- call them with `InterfaceName.methodName()` not inherited to implementing classes or extending interfaces

#### 7.2 Define and use a default method of an interface; Describe the inheritance rules for a default method
- adding default methods to interfaces allow functionality to be added to all implementors and ensure backward compatibility with legacy code
- a default method must have a method body
- the `default` keyword is used to define such a method
```java
interface Fab {
    default void great() { ... }
}
```
- they are called using an instance of the implementing class `implObj.great()`, but not `Fab.great()`
- on extending an interface with a default method, you can:
  1. make no mention of the method => inherited as is
  2. redeclare method, as a method signature (not default), then must be implemented
  3. redefine the method, so the new implementation is inherited
