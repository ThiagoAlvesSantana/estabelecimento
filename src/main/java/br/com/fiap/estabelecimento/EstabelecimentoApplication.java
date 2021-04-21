package br.com.fiap.estabelecimento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "br.com.fiap.estabelecimento.controller","br.com.fiap.estabelecimento.service" })
@EnableJpaRepositories(basePackages = { "br.com.fiap.estabelecimento.repository" })
@EntityScan(basePackages = { "br.com.fiap.estabelecimento.domain" })
public class EstabelecimentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstabelecimentoApplication.class, args);
	}

}
