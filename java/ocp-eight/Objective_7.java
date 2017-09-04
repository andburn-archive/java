import java.util.function.*;
import java.util.*;

public class Objective_7 {

  public static void main(String[] args) {

    Animal a = () -> "woof";
    System.out.println(a.name());
    a.speak();
    Animal.phylum();

    Mammal.phylum(); // symbol not found
    new Mammal().speak();

    Mutant.phylum(); // symbol not found

  }

}

interface Animal {

  String name();

  default void speak() {
    System.out.println("Moo");
  }

  static void phylum() {
    System.out.println("Animalia");
  }

}

interface Mutant extends Animal {
  default void speak() {
    System.out.println("Mawwagh");
  }
}

class Mammal implements Animal {
  public String name() { return "Mammal"; }
}
