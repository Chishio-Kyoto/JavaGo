import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class Sample02 {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "/Users/houle/Desktop/test01.txt";

        // 文件读取方式一：Scanner + FileReader
        long startTime = System.currentTimeMillis();
        try (Scanner sc = new Scanner(new FileReader(fileName))) {
            while (sc.hasNextLine()) {  //按行读取字符串
                String line = sc.nextLine();
                System.out.print("");
            }
            System.out.println("读取完成！");
        }
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) + " ms");

        long startTime_02 = System.currentTimeMillis();
        // 文件读取方式二：Files + Stream
        try(Stream<String> lines = Files.lines(Paths.get(fileName))) {
            lines.parallel().forEachOrdered(e -> System.out.print(""));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("读取完成！");
        }
        long endTime_02 = System.currentTimeMillis();
        System.out.println((endTime_02 - startTime_02) + " ms");

        // 文件读取方式三：Files.readAllBytes()、Files.readString()
        // 适合快速读取小文本文件，不超过2G

        // 文件读取方式四：BufferedReader
        long startTime_04 = System.currentTimeMillis();
        // 带缓冲的流读取，默认缓冲区8k
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = br.readLine()) != null) {
                System.out.print("");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("读取完成！");
        long endTime_04 = System.currentTimeMillis();
        System.out.println((endTime_04 - startTime_04) + " ms");

    }
}
