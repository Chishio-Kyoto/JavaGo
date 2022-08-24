package com.houle.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupsOnClass01 {
    public void stu01(){
        System.out.println("GroupsOnClass01中的stu01 运行");
    }

    public void stu02(){
        System.out.println("GroupsOnClass01中的stu02 运行");
    }
}
