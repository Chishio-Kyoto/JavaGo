package com.houle.testng;

import org.testng.annotations.Test;

public class TimeOutTest {
    @Test(timeOut = 3000)
    public void testSuccess() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test(timeOut = 2000, expectedExceptions=RuntimeException.class)
    public void testFailed() throws InterruptedException {
        Thread.sleep(3000);
        throw new InterruptedException();
    }
}
