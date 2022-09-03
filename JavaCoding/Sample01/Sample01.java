public class Sample01 {

    public static int nSum(int n) {
        return ((1+n)*n)/2;
    }

    // 一元二次方程求根
    public static double[] quadraticFormula(double a, double b, double c) {
        double temp = Math.sqrt(Math.pow(b, 2) - 4*a*c);
        double q1 = ((-1)*b + temp) / 2*a;
        double q2 = ((-1)*b - temp) / 2*a;
        double[] result = new double[2];
        result[0] = q1;
        result[1] = q2;
        return result;
    }

    public static void main(String[] args) {
        byte a = 2;
        short b = 10;
        int c = a + b;
        System.out.println(c);

        byte d = (byte) c;
        System.out.println(d);

        System.out.println(nSum(100));

        double x = 1.0 / 10;
        double y = 1 - 9.0 / 10;
        // 观察x和y是否相等:
        System.out.println(x);  // 0.1
        System.out.println(y);  // 0.09999999999999998

        // 比较x和y是否相等，先计算其差的绝对值
        double r = Math.abs(x - y);
        // 再判断绝对值是否足够小
        if (r < 0.0001) {
            System.out.println("x == y");
        } else {
            System.out.println("x != y");
        }

        // 类型提升
        int n = 5;
        double e = 1.2 + 24.0 / n;
        System.out.println(e);  // 6.0

        double f = 1.2 + 24 / 5;
        System.out.println(f);  // 5.2

        // 溢出
        double d1 = 0.0 / 0;
        double d2 = 1.0 / 0;
        double d3 = -1.0 / 0;
        System.out.println(d1);  // NaN
        System.out.println(d2);  // Infinity
        System.out.println(d3);  // -Infinity

        double[] result = quadraticFormula(1.0, 3.0, -4.0);
        for (double re: result
             ) {
            System.out.println(re);
        }

        String s = "hello";
        String t = s;
        s = "world";
        System.out.println(t);  // "hello"

        int a1 = 72;
        int b1 = 105;
        int c1 = 65281;
        String s1 = "" + a1 + b1 + c1;
        String s2 = "" + (char)a1 + (char)b1 + (char)c1;
        System.out.println(s1);  // 7210565281
        System.out.println(s2);  // Hi！
    }
}
