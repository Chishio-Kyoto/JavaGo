package daysix;

import java.util.concurrent.*;

public class PictureDownloadPlus {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        DownThreadPlus downThreadPlus1 = new DownThreadPlus("https://images.unsplash.com/photo-1558445034-78cfe390fee3?ixid=Mnw4OTgyNHwwfDF8c2VhcmNofDE4fHwlRTQlQkElQUMlRTklODMlQkR8ZW58MHx8fHwxNj" +
                "Y3NzQyNjU1&ixlib=rb-4.0.3&w=750&dpi=2", "Kyoto_001.jpg");
        DownThreadPlus downThreadPlus2 = new DownThreadPlus("https://images.unsplash.com/photo-1600786365542-15b9da44ef08?ixid=Mnw4OTgyNHwwfDF8c2VhcmNofDN8fCVFNCVCQSVBQyVFOSU4MyVCRHxlbnwwfHx8fDE" +
                "2Njc3NDI2NTU&ixlib=rb-4.0.3&w=750&dpi=2", "Kyoto_002.jpg");
        DownThreadPlus downThreadPlus3 = new DownThreadPlus("https://images.unsplash.com/photo-1600775081940-f849231d06d6?ixid=Mnw4OTgyNHwwfDF8c2VhcmNofDZ8fCVFNCVCQSVBQyVFOSU4MyVCRHxlbnwwfHx8fDE" +
                "2Njc3NDI2NTU&ixlib=rb-4.0.3&w=750&dpi=2", "Kyoto_003.jpg");

        // 创建执行服务
        ExecutorService service = Executors.newFixedThreadPool(3);

        // 提交执行
        Future<Boolean> d1 = service.submit(downThreadPlus1);
        Future<Boolean> d2 = service.submit(downThreadPlus2);
        Future<Boolean> d3 = service.submit(downThreadPlus3);

        // 获取结果
        boolean r1 = d1.get();
        boolean r2 = d2.get();
        boolean r3 = d3.get();
        System.out.printf("%s %s %s", r1, r2, r3);

        // 关闭服务
        service.shutdown();
    }
}

class DownThreadPlus implements Callable<Boolean> {

    private final String url;
    private final String name;

    DownThreadPlus(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() {
        Downloader downloader = new Downloader();
        downloader.downloader(url, name);
        System.out.println("下载了文件位：" + name);
        return true;
    }
}