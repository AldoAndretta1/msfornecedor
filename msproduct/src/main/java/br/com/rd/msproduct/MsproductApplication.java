package br.com.rd.msproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"br.com.rd"})
public class MsproductApplication {
	public static void main(String[] args) {
		SpringApplication.run(MsproductApplication.class, args);
	}
}