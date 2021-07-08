package br.com.rd.msfornecedor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"br.com.rd"})
public class MsFornecedorApplication {
	public static void main(String[] args) {
		SpringApplication.run(MsFornecedorApplication.class, args);
	}
}