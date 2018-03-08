import java.util.function.*;

public class Objective_2_8 {

  public static void main(String... args) {

    // Q: how do instance method references work on Supplier
    // A: can't be referenced from static context

    Supplier<String> s = () -> new String();
    s.get();

    s = String::new;
    s.get();

    s = String::trim; // error
    s.get();

    // Q: what about Consumer
    // A: ok, if not actually using return

    Consumer<String> c = str -> { return str.trim(); }; // error
    c = String::trim;
    c.accept("abc");

    // specific object
    String v = "a string";
    Predicate<String> p = v::equalsIgnoreCase;
    System.out.println(p.test("A StrinG"));
  }

}
