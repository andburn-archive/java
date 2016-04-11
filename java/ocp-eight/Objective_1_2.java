public class Objective_1_2 {

  public static void main(String[] args) {
    Dog d = new Dog();
    d.speak();
  }

}

@FunctionalInterface
interface Animal {

  void eat();

  // only one abstract method allowed
  /* Unexpected @FunctionalInterface annotation */
  //void sleep();

  // default methods must have a method body
  /* error: missing method body, or declare abstract */
  default void speak() {
    System.out.println("Animal talk");
  }
}

interface Mammal extends Animal {
}

class Dog implements Mammal {
  // public void speak() {
  //   System.out.println("Woof!");
  // }
  public void eat() {
    System.out.println("Nonomomm");
  }
}
