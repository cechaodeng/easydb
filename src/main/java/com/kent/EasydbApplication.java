package com.kent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.kent.dao")
public class EasydbApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasydbApplication.class, args);
	}
}
