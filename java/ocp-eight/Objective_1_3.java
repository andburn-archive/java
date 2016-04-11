public class Objective_1_3 {

  public static void main(String[] args) {

    watch(new Animal() {
      public void eat() {
        System.out.println("Omnomm!");
      }
    });

    watch(() -> System.out.println("GrrArrr"));
    //watch(int s -> s * 3);// syntax error
    watch(s, t -> s * 3);
  }

  static void watch(Animal a) {
    a.eat();
  }

  static void watch(Plant p) {
    System.out.println(p.grow(10, "high"));
  }
}

@FunctionalInterface
interface Animal {
  void eat();
}

interface Plant {
  int grow(int solar, String type);
}
