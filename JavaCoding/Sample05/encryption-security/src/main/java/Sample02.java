import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sample02 {
    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        System.out.println("hello".hashCode());
        System.out.println("hello ".hashCode());
        System.out.println(" hello".hashCode());

        // 哈希碰撞
        System.out.println("AaAaAa".hashCode());  // 1952508096
        System.out.println("BBAaBB".hashCode());  // 1952508096
        System.out.println("CCAaCC".hashCode());  // 1982060800

        // 创建一个MessageDigest实例:
        MessageDigest md = MessageDigest.getInstance("MD5");
        // 反复调用update输入数据:
        md.update("Hello".getBytes(StandardCharsets.UTF_8));
        md.update("World".getBytes(StandardCharsets.UTF_8));
        // 得到输入HelloWorld的MD5
        byte[] result = md.digest();  // 16 bytes: 68e109f0f40ca72a15e05cc22786f8e6
        System.out.println(new BigInteger(1, result).toString(16));

        // 创建一个MessageDigest实例:
        MessageDigest md2 = MessageDigest.getInstance("SHA-1");
        // 反复调用update输入数据:
        md2.update("Hello".getBytes(StandardCharsets.UTF_8));
        md2.update("World".getBytes(StandardCharsets.UTF_8));
        // 得到输入HelloWorld的SHA-1
        byte[] result2 = md2.digest();  // 20 bytes: db8ac1c259eb89d4a131b253bacfca5f319d54f2
        System.out.println(new BigInteger(1, result2).toString(16));
    }
}
