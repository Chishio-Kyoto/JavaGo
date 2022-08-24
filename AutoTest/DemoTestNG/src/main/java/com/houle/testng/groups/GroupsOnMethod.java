package com.houle.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {
    @Test(groups = "server")
    public void test01(){
        System.out.println("这是服务端组的测试方法01");
    }

    @Test(groups = "server")
    public void test02(){
        System.out.println("这是服务端组的测试方法02");
    }

    @Test(groups = "server")
    public void test03(){
        System.out.println("这是服务端组的测试方法03");
    }

    @Test(groups = "client")
    public void test04(){
        System.out.println("这是客户端组的测试方法04");
    }

    @Test(groups = "client")
    public void test05(){
        System.out.println("这是客户端组的测试方法05");
    }

    @BeforeGroups("server")
    public void beforeGroupsOnServer(){
        System.out.println("这是服务组运行之前运行的方法");
    }

    @AfterGroups("server")
    public void afterGroupsOnServer(){
        System.out.println("这是服务组运行之后运行的方法");
    }
}
