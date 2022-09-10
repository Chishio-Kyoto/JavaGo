import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Sample01 {
    public static void main(String[] args) throws UnsupportedEncodingException {

        /**
         * NumberFormatException
         * String s = "abc";
         * int n = Integer.parseInt(s);  // NumberFormatException
         */

        byte[] bs = toGBK("中文");
        System.out.println(Arrays.toString(bs));
        byte[] bs2 = toGBK2("中文");
        System.out.println(Arrays.toString(bs2));
    }

    static byte[] toGBK(String s) {
        try {
            // 用指定编码转换String为byte[]:
            return s.getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
            // 如果系统不支持GBK编码，会捕获到UnsupportedEncodingException:
            System.out.println(e); // 打印异常信息
            return s.getBytes(); // 尝试使用用默认编码
        }
    }

    static byte[] toGBK2(String s) throws UnsupportedEncodingException{
        return s.getBytes("GBK");
    }
}
