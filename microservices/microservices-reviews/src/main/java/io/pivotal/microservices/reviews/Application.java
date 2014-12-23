package io.pivotal.microservices.reviews;

import io.pivotal.microservices.reviews.models.Review;
import io.pivotal.microservices.reviews.repositories.ReviewRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@SpringBootApplication
@EnableMongoRepositories
@EnableDiscoveryClient
public class Application extends RepositoryRestMvcConfiguration implements CommandLineRunner {

    @Autowired
    ReviewRepository reviewRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        reviewRepository.deleteAll();
    }
    
    @Override
   	protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
   		config.exposeIdsFor(Review.class);
   	}

}
