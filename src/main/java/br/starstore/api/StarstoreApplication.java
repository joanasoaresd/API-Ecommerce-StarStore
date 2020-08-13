package br.starstore.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class StarstoreApplication {
	
//	@Bean
//	public FilterRegistrationBean<TokenFilter> filterJwt() {
//		System.out.println("Entrou aqui");
//		FilterRegistrationBean<TokenFilter> filterRB = new FilterRegistrationBean<TokenFilter>();
//		filterRB.setFilter(new TokenFilter());
//		filterRB.addUrlPatterns("/users", "/login");
//		return filterRB;
//	}

	public static void main(String[] args) {
		SpringApplication.run(StarstoreApplication.class, args);
	}

}
