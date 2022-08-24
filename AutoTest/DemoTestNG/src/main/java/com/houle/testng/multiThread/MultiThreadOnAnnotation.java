package com.houle.testng.multiThread;

import org.testng.annotations.Test;

public class MultiThreadOnAnnotation {
    @Test(invocationCount = 10, threadPoolSize = 5)
    public void test(){
        System.out.println(1);
        System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());
    }
}