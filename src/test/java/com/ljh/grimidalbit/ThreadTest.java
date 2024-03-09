//package com.ljh.grimidalbit;
//
//import org.springframework.data.domain.Example;
//
//public class ThreadTest extends Thread{
//
//    int num;
//    public Example(int num){
//        this.num = num;
//    }
//
//    public void run() {
//        System.out.println(this.num + " thread start.");  // 쓰레드 시작
//        try {
//            Thread.sleep(1000);  // 1초 대기한다.
//        } catch (Exception e) {
//
//        }
//        System.out.println(this.num + " thread end.");  // 쓰레드 종료
//    }
//
//    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {  // 10개 쓰레드 실행
//            Thread t = new Example(i);
//            t.start();
//        }
//        System.out.println("main end.");  // main 메소드 종료
//    }
//}
