package com.houle.testng;

import org.testng.annotations.*;

public class BasicAnnotation {

    @Test
    public void testCase01() {
        System.out.println("这是测试用例01");
    }

    @Test
    public void testCase02() {
        System.out.println("这是测试用例02");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("这是在测试方法之前运行的");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("这是在测试方法之后运行的");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("这是在类之前运行的");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("这是在类之后运行的");
    }
}
