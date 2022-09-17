public class Sample01 {
    public static void main(String[] args) throws ClassNotFoundException {
        String s1 = "Hello";
        Class cls = s1.getClass();

        // class java.lang.String
        System.out.println(String.class);
        System.out.println(cls);
        System.out.println(Class.forName("java.lang.String"));

        // == 与 instanceof
        Integer n = 123;
        System.out.println(n.getClass());
        System.out.println(Integer.class);
        System.out.println(Number.class);
        System.out.println(n instanceof Integer);  // true
        System.out.println(n instanceof Number);  // true

        Class cls2 = n.getClass();
        System.out.println(cls2.getName());
        System.out.println(cls2.getSimpleName());
        System.out.println(cls2.isArray());
    }
}
