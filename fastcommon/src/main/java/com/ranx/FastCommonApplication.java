package com.ranx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages="com.ranx" ,exclude= {DataSourceAutoConfiguration.class})
public class FastCommonApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastCommonApplication.class, args);
	}

}
