package org.literal.qjxt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// alt + / 代码提示

@SpringBootApplication
@MapperScan(basePackages = {"org.literal.qjxt.dao"})
public class QjxtApplication {

	public static void main(String[] args) {
		SpringApplication.run(QjxtApplication.class, args);
	}

}
