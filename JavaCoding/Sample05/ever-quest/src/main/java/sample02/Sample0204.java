package sample02;

public class Sample0204 {
    public static void main(String[] args) {
        Pair[] arr = new Pair[2];
        Pair<String>[] ps = (Pair<String>[]) arr;

        ps[0] = new Pair<String>("a", "b");
        arr[1] = new Pair<Integer>(1, 2);

        Pair<String> p = ps[1];
        String s = p.getFirst();  // ClassCastException

        @SuppressWarnings("unchecked")
        Pair<String>[] ps2 = (Pair<String>[]) new Pair[2];
    }
}
