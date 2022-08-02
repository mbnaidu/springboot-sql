package net.javaguides.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringBootSql1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSql1Application.class, args);
		System.out.println("hie");
	}

}
