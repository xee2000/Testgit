package com.ljh.grimidalbit;

import com.ljh.grimidalbit.service.SearchImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableScheduling
@EnableTransactionManagement
public class GrimidalbitApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrimidalbitApplication.class, args);
		System.out.println(Thread.currentThread().getName() + "-> MAIN");

	}

}
