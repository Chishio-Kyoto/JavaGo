package com.houle.testng;

import org.testng.annotations.Test;

public class ExpectedException {
    /**
     * 什么时候会用到异常测试
     * 在期望结果为某一个异常的时候
     * 比如：传入不合法的参数，程序抛出异常
     * 即预期结果就是对应的异常
     */

    /**
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionFailed(){
        System.out.println("这是一个失败的异常测试");
    }
    */

    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSuccess(){
        System.out.println("这是一个成功的异常测试");
        throw new RuntimeException();
    }
}
