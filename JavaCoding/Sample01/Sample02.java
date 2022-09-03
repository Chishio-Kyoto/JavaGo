public class Sample02 {

    public static void main(String[] args) {
        // 5位同学的成绩:
        int[] ns = new int[] { 68, 79, 91, 85, 62 };
        System.out.println(ns.length); // 编译器自动推算数组大小为5

        int[] ns2 = { 68, 79, 91, 85, 62 };
        System.out.println(ns2.length);  // 5

        String[] names = {"ABC", "XYZ", "zoo"};
        String s = names[1];
        System.out.println(s);  // "XYZ"
        names[1] = "cat";
        System.out.println(s);  // "XYZ"
        String s1 = names[1];
        System.out.println(s1);  // "cat"
        s = names[1];
        System.out.println(s);  // "cat"

        // 命令行参数
        for (String arg : args) {
            if ("-version".equals(arg)) {
                System.out.println("v 1.0");
                break;
            }
        }
    }
}
