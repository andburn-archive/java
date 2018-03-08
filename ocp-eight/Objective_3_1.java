import java.util.function.*;
import java.util.*;

public class Objective_3_1 {

  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("one");
    list.add("two");

    Consumer<String> c1 = String::toUpperCase;
    Consumer<String> c2 = System.out::println;
    list.forEach(c1.andThen(c2));
  }
}
