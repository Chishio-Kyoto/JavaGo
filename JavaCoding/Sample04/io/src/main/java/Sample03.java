import java.io.*;
import java.util.Arrays;

public class Sample03 {
    public static <e> void main(String[] args) throws FileNotFoundException {
        String fileName = "/Users/houle/Desktop/test01.txt";

        long startTime_01 = System.currentTimeMillis();
        // 带缓冲的流读取，默认缓冲区8k
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = br.readLine()) != null) {
                System.out.print(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("读取完成！");
        long endTime_01 = System.currentTimeMillis();
        System.out.println((endTime_01 - startTime_01) + " ms");

        long startTime_02 = System.currentTimeMillis();
        try (BufferedInputStream br = new BufferedInputStream(new FileInputStream(fileName))){
            byte[] bytes = new byte[1024];
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int count = 0;
            while(( count = br.read( bytes))!= -1){
                bos.write( bytes, 0, count);// 写入到输出流
            }
            System.out.println(bos.toString());
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("读取完成！");
        long endTime_02 = System.currentTimeMillis();
        System.out.println((endTime_02 - startTime_02) + " ms");
        long startTime_03 = System.currentTimeMillis();
        try (FileReader ps = new FileReader(fileName)) {
            int count = 0;
            while((count = ps.read())!= -1){
                System.out.println(ps.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("读取完成！");
        long endTime_03 = System.currentTimeMillis();
        System.out.println((endTime_03 - startTime_03) + " ms");
    }
}
