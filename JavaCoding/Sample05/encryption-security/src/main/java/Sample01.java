import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

public class Sample01 {
    public static void main(String[] args) {
        String encoded = URLEncoder.encode("中文", StandardCharsets.UTF_8);
        System.out.println(encoded);  // %E4%B8%AD%E6%96%87

        String decoded = URLDecoder.decode("%E4%B8%AD%E6%96%87", StandardCharsets.UTF_8);
        System.out.println(decoded);  // 中文

        byte[] input = new byte[] { (byte) 0xe4, (byte) 0xb8, (byte) 0xad };
        String b64encoded = Base64.getEncoder().encodeToString(input);
        System.out.println(b64encoded);  // 5Lit

        byte[] output = Base64.getDecoder().decode("5Lit");
        System.out.println(Arrays.toString(output));  // [-28, -72, -83]

        byte[] input2 = new byte[] { 0x01, 0x02, 0x7f, 0x00 };
        String b64encoded2 = Base64.getUrlEncoder().encodeToString(input2);
        System.out.println(b64encoded2);  // AQJ_AA==
        byte[] output2 = Base64.getUrlDecoder().decode(b64encoded2);
        System.out.println(Arrays.toString(output2));  // [1, 2, 127, 0]
    }
}
