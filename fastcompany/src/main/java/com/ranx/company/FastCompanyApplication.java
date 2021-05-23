package com.ranx.company;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.ranx")
@MapperScan("com.ranx.company.mapper.*")
public class FastCompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastCompanyApplication.class, args);
	}

}
