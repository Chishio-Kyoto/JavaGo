package com.houle.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import javax.annotation.PreDestroy;

@EnableScheduling
@SpringBootApplication
public class DemoMybatisApplication {

    private  static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        DemoMybatisApplication.context = SpringApplication.run(DemoMybatisApplication.class,args);
    }

    @PreDestroy
    public void close(){
        DemoMybatisApplication.context.close();
    }

}