package com.pichincha.service;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

@SpringBootApplication
public class AppPichinchaExchangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppPichinchaExchangeApplication.class, args);
	}

	@Bean
	public ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
		ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
		initializer.setConnectionFactory(connectionFactory);
		initializer.setDatabasePopulator(new CompositeDatabasePopulator(
				new ResourceDatabasePopulator(new ClassPathResource("schema.sql"))
				//new ResourceDatabasePopulator(new ClassPathResource("data.sql"))
		));
		return initializer;
	}
}
