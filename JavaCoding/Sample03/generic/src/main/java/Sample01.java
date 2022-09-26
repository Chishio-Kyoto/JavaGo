import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sample01 {
    public static void main(String[] args) {
        // 编译器如果能自动推断出泛型类型，就可以省略后面的泛型类型
        // ArrayList<Double> arrayList = new ArrayList<Double>();
        ArrayList<Double> arrayList = new ArrayList<>();
        arrayList.add(9.23);
        System.out.println(arrayList.get(0));
        // arrayList.add(new Integer(10));  // compile error!
        // System.out.println(arrayList.get(1));  // IndexOutOfBoundsException
        List<Double> list = arrayList;
        list.add(11.22);
        System.out.println(list.get(0));  // 9.23
        System.out.println(arrayList.get(1));  // 11.22

        String[] ss = new String[] { "Orange", "Apple", "Pear" };
        Arrays.sort(ss);
        System.out.println(Arrays.toString(ss));

        Person[] ps = new Person[] {
                new Person("Bob", 11),
                new Person("Alice", 88),
                new Person("Lily", 75),
        };
        // Arrays.sort(ps);  // ClassCastException，需要实现Comparable<T>接口
        Arrays.sort(ps);
        System.out.println(Arrays.toString(ps));

        Pair<Integer> p1 = new IntPair(2, 4);
        Pair<Integer> p2 = Pair.create(2, 4);
        System.out.println(p1.getFirst());
        System.out.println(p2.getFirst());

        Class c1 = p1.getClass();
        System.out.println(c1);  // class IntPair, 无法获得Integer

        // Pair<Integer> p = new Pair<>(123, 456);
        // Compile error:
        /*
        if (p instanceof Pair<String>) {
        }
         */
    }
}
