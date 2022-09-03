import java.util.Scanner;

public class Sample03 {
    public static String BMI(double weight, double high) {
        double bmi = weight / Math.pow(high, 2);
        System.out.println(bmi);
        String result;
        if (bmi < 18.5) {
            result = "过轻：低于18.5";
        } else if (bmi >= 18.5 && bmi < 25.0) {
            result = "正常：18.5-25";
        } else if (bmi >= 25.0 && bmi < 28.0) {
            result = "过重：25-28";
        } else if (bmi >= 28.0 && bmi < 32.0) {
            result = "肥胖：28-32";
        } else {
            result = "非常肥胖：高于32";
        }
        return result;
    }

    public static double PI() {
        double PI;
        double pi = 0;
        for(int i=0; i<10000000; i++){
            pi += Math.pow(-1, i) / (i*2 + 1);
        }
        PI = 4 * pi;
        return PI;
    }

    public static void main(String[] args) {
        /**
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入：");
        String name = scanner.nextLine();
        System.out.println(name);
        System.out.print("请输入：");
        int age = scanner.nextInt();
        System.out.println(age);
         */

        // 格式化
        int n = 12345000;
        System.out.printf("n=%d, hex=%08x", n, n); // 注意，两个%占位符必须传入两个数

        // 判断引用类型相等
        String s1 = "hello";
        String s2 = "HELLO".toLowerCase();
        System.out.println(s1);
        System.out.println(s2);
        if (s1 == s2) {
            System.out.println("s1 == s2");
        } else {
            System.out.println("s1 != s2");  // ✅
        }

        if (s1.equals(s2)) {
            System.out.println("s1 == s2");  // ✅
        } else {
            System.out.println("s1 != s2");
        }

        // 优化版本
        if (s1 != null && s1.equals(s2)) {
            System.out.println("s1 == s2");  // ✅
        } else {
            System.out.println("s1 != s2");
        }

        // BMI计算
        String myBMI = BMI(68.0, 1.72);
        System.out.println(myBMI);  // 正常：18.5-25

        int option = 2;
        switch (option) {
            case 1:
                System.out.println("Selected 1");
                break;
            case 2:
            case 3:
                System.out.println("Selected 2, 3");
                break;
            default:
                System.out.println("Not selected");
                break;
        }

        int sum = 0;
        int n1 = 0;
        while (n1 < 100) {
            n1 ++;
            sum = sum + n1;
        }
        System.out.println(sum);

        double PI = PI();
        System.out.println(PI);
    }
}
