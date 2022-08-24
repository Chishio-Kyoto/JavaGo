package com.houle.testng.multiThread;

import org.testng.annotations.Test;

public class MultiThreadOnXml {
    @Test
    public void test01(){
        System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());
    }

    @Test
    public void test02(){
        System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());
    }

    @Test
    public void test03(){
        System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());
    }
}
