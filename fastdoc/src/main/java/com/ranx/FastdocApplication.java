package com.ranx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.ranx")
@MapperScan("com.ranx.mapper.*")
public class FastbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastbootApplication.class, args);
	}

}
