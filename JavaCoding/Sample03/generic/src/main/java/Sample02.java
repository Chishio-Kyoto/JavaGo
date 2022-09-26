public class Sample02 {
    public static void main(String[] args) {
        Pair<Integer> p1 = new Pair<>(123, 456);
        Pair<Number> p2 = new Pair<>(1, 2);
        // incompatible types: Pair<Integer> cannot be converted to Pair<Number>
        // int n1 = add(p1);
        int n2 = add(p2);
        // System.out.println(n1);
        System.out.println(n2);

        int n3 = add2(p1);
        int n4 = add2(p2);
        System.out.println(n3);
        System.out.println(n4);
    }

    static int add(Pair<Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        return first.intValue() + last.intValue();
    }

    static int add2(Pair<? extends Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        return first.intValue() + last.intValue();
    }

    static int add3(Pair<? extends Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        // 编译错误
        // p.setFirst(new Integer(first.intValue() + 100));
        // p.setLast(new Integer(last.intValue() + 100));
        return first.intValue() + last.intValue();
    }
}
