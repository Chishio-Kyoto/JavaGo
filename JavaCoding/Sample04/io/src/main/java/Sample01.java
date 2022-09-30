import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class Sample01 {
    public static void main(String[] args) throws IOException {

        // 写入文件方式一：FileWriter
        long startTime = System.currentTimeMillis();
        try (FileWriter fileWriter = new FileWriter("/Users/houle/Desktop/test01.txt")) {
            for (int i = 0; i < 1000000; i++) {
                String tempStr = getRandomString(10);
                fileWriter.write(tempStr+"\n");
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) + " ms");

        // 写入文件方式二：BufferedWriter
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/houle/Desktop/test02.txt"))) {
            long startTime_02 = System.currentTimeMillis();
            for (int i = 0; i < 1000000; i++) {
                String tempStr = getRandomString(10);
                bufferedWriter.write(tempStr+"\n");
            }
            long endTime_02 = System.currentTimeMillis();
            System.out.println((endTime_02 - startTime_02) + " ms");
        }

        // 写入文件方式三：PrintWriter
        try (PrintWriter printWriter = new PrintWriter(new FileWriter("/Users/houle/Desktop/test03.txt"))) {
            long startTime_03 = System.currentTimeMillis();
            for (int i = 0; i < 1000000; i++) {
                String tempStr = getRandomString(10);
                printWriter.write(tempStr+"\n");
            }
            long endTime_03 = System.currentTimeMillis();
            System.out.println((endTime_03 - startTime_03) + " ms");
        }

        // 写入文件方法四：FileOutputStream
        try (FileOutputStream fileOutputStream = new FileOutputStream("/Users/houle/Desktop/test04.txt")) {
            long startTime_04 = System.currentTimeMillis();
            for (int i = 0; i < 1000000; i++) {
                String tempStr = getRandomString(10) + "\n";
                byte[] bytes = tempStr.getBytes(StandardCharsets.UTF_8);
                fileOutputStream.write(bytes);
            }
            long endTime_04 = System.currentTimeMillis();
            System.out.println((endTime_04 - startTime_04) + " ms");
        }

        // 写入文件方法五：BufferedOutputStream
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("/Users/houle/Desktop/test05.txt"))) {
            long startTime_05 = System.currentTimeMillis();
            for (int i = 0; i < 1000000; i++) {
                String tempStr = getRandomString(10) + "\n";
                byte[] bytes = tempStr.getBytes(StandardCharsets.UTF_8);
                bufferedOutputStream.write(bytes);
            }
            long endTime_05 = System.currentTimeMillis();
            System.out.println((endTime_05 - startTime_05) + " ms");
        }

        // 写入文件方法六：Files类
        try {
            long startTime_06 = System.currentTimeMillis();
            for (int i = 0; i < 1000000; i++) {
                String tempStr = getRandomString(10) + "\n";
                Files.write(Paths.get("/Users/houle/Desktop/test06.txt"),
                        tempStr.getBytes(StandardCharsets.UTF_8));
            }
            long endTime_06 = System.currentTimeMillis();
            System.out.println((endTime_06 - startTime_06) + " ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
