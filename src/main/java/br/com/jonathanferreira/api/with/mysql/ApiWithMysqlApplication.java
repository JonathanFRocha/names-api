package br.com.jonathanferreira.api.with.mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "br.com.jonathanferreira.api.with.mysql")
@EntityScan(basePackages = "br.com.jonathanferreira.api.with.mysql.model")
public class ApiWithMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiWithMysqlApplication.class, args);
	}

}
