package dayfive;

import java.util.UUID;
import java.util.concurrent.Semaphore;

public class Sample001 {
    public static void main(String[] args) {
        System.out.println("hahahahahah......");
    }
}

class AccessLimitControl {
    // 任意时刻仅允许最多3个线程获取许可:
    final Semaphore semaphore = new Semaphore(3);

    public String access() throws Exception {
        // 如果超过了许可数量,其他线程将在此等待:
        semaphore.acquire();
        try {
            return UUID.randomUUID().toString();
        } finally {
            semaphore.release();
        }
    }
}