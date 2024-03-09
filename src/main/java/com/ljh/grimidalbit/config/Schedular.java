package com.ljh.grimidalbit.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class Schedular {

    @Scheduled(fixedDelay =  1000)
    public void test1(){
        try{
            System.out.println(Thread.currentThread().getName() + "-> 부하테스트1");
            Thread.sleep(10000);
        }catch(InterruptedException e){
            e.printStackTrace();
            Thread.interrupted();
        }
    }

    @Scheduled(fixedDelay =  1000)
    public void test2(){
        try{
            System.out.println(Thread.currentThread().getName() + "-> 부하테스트2");
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
            Thread.interrupted();
        }
    }
}
