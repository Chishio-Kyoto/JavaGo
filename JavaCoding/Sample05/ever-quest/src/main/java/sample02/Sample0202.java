package sample02;

public class Sample0202 {
    public static void main(String[] args) {
        Pair<Integer> p = new Pair<>(123, 456);
        // java: 不兼容的类型: Pair<java.lang.Integer>无法转换为Pair<java.lang.Number>
        // int n1 = PairHelper.add(p);
        // System.out.println(n1);

        int n2 = PairHelper.add1(p);
        System.out.println(n2);

        // java: 不兼容的类型: java.lang.Integer无法转换为capture#1, 共 ? extends java.lang.Number
        // int n3 = PairHelper.add2(p);
        // System.out.println(n3);

        Pair<Number> p1 = new Pair<>(12.3, 4.56);
        Pair<Integer> p2 = new Pair<>(123, 456);
        setSame(p1, 100);
        setSame(p2, 200);
        System.out.println(p1.getFirst() + ", " + p1.getLast());
        System.out.println(p2.getFirst() + ", " + p2.getLast());
    }

    static void setSame(Pair<? super Integer> p, Integer n) {
        p.setFirst(n);
        p.setLast(n);
    }
}
