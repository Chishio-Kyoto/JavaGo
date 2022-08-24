package com.houle.report;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestMethodsDemo {
    @Test
    public void test01(){
        Assert.assertEquals(1, 2);
    }

    @Test
    public void test02(){
        Assert.assertEquals(1, 1);
    }

    @Test
    public void test03(){
        Assert.assertEquals(1, 0);
    }

    public void logDemo(){
        Reporter.log("这是我们自己写的日志");
        throw new RuntimeException("这是我自己的运行时异常");
    }
}
