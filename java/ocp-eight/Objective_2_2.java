import java.util.function.*;

public class Objective_2_2 {

  public static void main(String... args) {

    // Q: do functional interfaces use primitive wrappers
    // A: yes
    Function<String, Boolean> f = s -> s == "string";
    boolean b = f.apply("string");
    
    System.out.println(f.apply("not a string"));
    System.out.println(b);
  }

}
