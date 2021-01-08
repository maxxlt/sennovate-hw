package com.sennovate.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sennovate.*"})
@EntityScan(basePackages = {"com.sennovate.*"})

@EnableMongoRepositories(basePackages = {"com.sennovate.*"})
public class SpringBootDriver {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDriver.class);
    }
}
