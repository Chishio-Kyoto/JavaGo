import java.util.Deque;
import java.util.LinkedList;

public class StackSample {
    public static void main(String[] args) {
        String hex = toHex(12500);
        if (hex.equalsIgnoreCase("30D4")) {
            System.out.println("测试通过");
        } else {
            System.out.println("测试失败");
        }
    }

    static String toHex(int n) {
        Deque<String> result = new LinkedList<>();
        String temp2 = "";
        while(n / 16 != 0) {
            temp2 = n % 16 + "";
            n = n / 16;
            switch (temp2) {
                case "10":
                    temp2 = "A";
                    break;
                case "11":
                    temp2 = "B";
                    break;
                case "12":
                    temp2 = "C";
                    break;
                case "13":
                    temp2 = "D";
                    break;
                case "14":
                    temp2 = "E";
                    break;
                case "15":
                    temp2 = "F";
                    break;
            }
            result.push(temp2);
        }
        temp2 = n % 16 + "";
        result.push(temp2);
        return String.join("", result);
    }
}
