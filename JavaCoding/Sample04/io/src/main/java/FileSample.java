import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileSample {
    public static void main(String[] args) throws IOException {
        File f = new File("/Users/houle/Desktop/test.txt");
        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getCanonicalPath());
        System.out.println(File.separator);

        System.out.println(f.isFile());
        System.out.println(f.isDirectory());

        InputStream input = new FileInputStream("/Users/houle/Desktop/test.txt");
        for(;;) {
            int n = input.read();
            if (n == -1) {
                break;
            }
            System.out.println(n);
        }
        input.close();

        InputStream input1 = null;
        try {
            input1 = new FileInputStream("/Users/houle/Desktop/test.txt");
            int n;
            while ((n = input1.read()) != -1) {
                System.out.println(n);
            }
        } finally {
            if (input1 != null) {
                input1.close();
            }
        }

        try (InputStream input2 = new FileInputStream("/Users/houle/Desktop/test.txt")) {
            int n;
            while ((n = input2.read()) != -1) {
                System.out.println(n);
            }
        } // 编译器在此自动为写入finally并调用close()

        try (InputStream input3 = new FileInputStream("/Users/houle/Desktop/test.txt")) {
            // 定义1000个字节大小的缓冲区:
            byte[] buffer = new byte[1000];
            int n;
            while ((n = input3.read(buffer)) != -1) { // 读取到缓冲区
                System.out.println("read " + n + " bytes.");
            }
        }
    }
}
