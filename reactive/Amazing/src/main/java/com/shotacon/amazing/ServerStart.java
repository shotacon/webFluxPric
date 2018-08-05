package com.shotacon.amazing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 服务启动类.
 * 
 * @author shota
 *
 */
@SpringBootApplication
@MapperScan("com.shotacon.amazing")
public class ServerStart {

	public static void main(String[] args) {
		SpringApplication.run(ServerStart.class, args);
	}
}
