import java.util.Objects;
import java.util.Random;

public class Sample {
    public static void main(String[] args) {
        String[] strings = new String[10];
        for (int i = 0; i < 10; i++) {
            strings[i] = getRandomString();
        }
        for (String str: strings
             ) {
            int index = Objects.hashCode(str);
            System.out.println(index & 0x64);
        }
    }

    public static String getRandomString() {
        String str="zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 31; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
