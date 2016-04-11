import java.util.function.*;

public class Objective_2_5 {

  public static void main(String... args) {
    UnaryOperator<String> o = s -> "string" + s;
    String s = o.apply(" more strings");
    System.out.println(s);
  }

}
