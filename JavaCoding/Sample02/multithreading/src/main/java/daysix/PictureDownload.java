package daysix;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class PictureDownload {
    public static void main(String[] args) {
        DownloadThread downloadThread1 = new DownloadThread("https://images.unsplash.com/photo-1558445034-78cfe390fee3?ixid=Mnw4OTgyNHwwfDF8c2VhcmNofDE4fHwlRTQlQkElQUMlRTklODMlQkR8ZW58MHx8fHwxNj" +
                "Y3NzQyNjU1&ixlib=rb-4.0.3&w=750&dpi=2", "Kyoto_001.jpg");
        DownloadThread downloadThread2 = new DownloadThread("https://images.unsplash.com/photo-1600786365542-15b9da44ef08?ixid=Mnw4OTgyNHwwfDF8c2VhcmNofDN8fCVFNCVCQSVBQyVFOSU4MyVCRHxlbnwwfHx8fDE" +
                "2Njc3NDI2NTU&ixlib=rb-4.0.3&w=750&dpi=2", "Kyoto_002.jpg");
        DownloadThread downloadThread3 = new DownloadThread("https://images.unsplash.com/photo-1600775081940-f849231d06d6?ixid=Mnw4OTgyNHwwfDF8c2VhcmNofDZ8fCVFNCVCQSVBQyVFOSU4MyVCRHxlbnwwfHx8fDE" +
                "2Njc3NDI2NTU&ixlib=rb-4.0.3&w=750&dpi=2", "Kyoto_003.jpg");
        downloadThread1.start();
        downloadThread2.start();
        downloadThread3.start();
    }
}

class DownloadThread extends Thread {

    private final String url;
    private final String name;

    public DownloadThread(String url, String name) {
        this.url = url;
        this.name = name;
    }


    @Override
    public void run() {
        Downloader downloader = new Downloader();
        downloader.downloader(url, name);
        System.out.println("下载了文件位：" + name);
    }
}

class Downloader {
    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件下载失败～");
        }
    }
}
