package br.starstore.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import br.starstore.api.filters.TokenFilter;

@SpringBootApplication
public class StarstoreApplication {
	
	@Bean
	public FilterRegistrationBean<TokenFilter> filterJwt() {
		FilterRegistrationBean<TokenFilter> filterRB = new FilterRegistrationBean<TokenFilter>();
		filterRB.setFilter(new TokenFilter());
		filterRB.addUrlPatterns("/users", "/login");
		return filterRB;
	}

	public static void main(String[] args) {
		SpringApplication.run(StarstoreApplication.class, args);
	}

}
