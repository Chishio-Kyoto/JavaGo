import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Sample04 {
    public static void main(String[] args) {
        // char[] > string
        String str1 = new String(new char[] {
                'a', '1', '@', 'q'
        });
        System.out.println(str1);

        // string > byte[] 编码
        byte[] bytes = str1.getBytes(StandardCharsets.UTF_8);
        System.out.println(Arrays.toString(bytes));

        // byte[] > string 解码
        String str2 = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(str2);

        // string > char[]
        char[] chars = new char[str1.length()];
        str1.getChars(0, str1.length(), chars,0);
        System.out.println(Arrays.toString(chars));
    }
}
