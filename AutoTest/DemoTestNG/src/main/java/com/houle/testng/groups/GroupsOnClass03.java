package com.houle.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class GroupsOnClass03 {
    public void teacher01(){
        System.out.println("GroupsOnClass03中的teacher01 运行");
    }

    public void teacher02(){
        System.out.println("GroupsOnClass03中的teacher02 运行");
    }
}
