package com.wwj.showSystem;
import org.mybatis.spring.annotation.MapperScan;
/**
 * 项目的启动文件
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wwj.showSystem.mapper")
public class ShowSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShowSystemApplication.class, args);
	}

}
