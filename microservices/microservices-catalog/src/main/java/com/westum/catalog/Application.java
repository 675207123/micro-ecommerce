package com.westum.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import com.westum.catalog.models.Category;
import com.westum.catalog.models.Product;

@SpringBootApplication
@EnableJpaRepositories
@EnableDiscoveryClient
public class Application extends RepositoryRestMvcConfiguration {

	@Override
	protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Product.class, Category.class);
	}
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
