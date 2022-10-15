import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Sample04 {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        // 通过名称HmacMD5获取KeyGenerator实例
        KeyGenerator keyGen = KeyGenerator.getInstance("HmacMD5");
        // 通过KeyGenerator创建一个SecretKey实例
        SecretKey key = keyGen.generateKey();
        // 打印随机生成的key:
        byte[] skey = key.getEncoded();
        System.out.println(new BigInteger(1, skey).toString(16));

        // 通过名称HmacMD5获取Mac实例
        Mac mac = Mac.getInstance("HmacMD5");
        // 用SecretKey初始化Mac实例
        mac.init(key);
        // 对Mac实例反复调用update(byte[])输入数据
        mac.update("HelloWorld".getBytes(StandardCharsets.UTF_8));
        // 调用Mac实例的doFinal()获取最终的哈希值。
        byte[] result = mac.doFinal();
        System.out.println(new BigInteger(1, result).toString(16));
    }
}
