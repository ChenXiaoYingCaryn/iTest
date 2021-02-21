package com.itest.itesteureka7001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ItestEureka7001Application {

    public static void main(String[] args) {
        SpringApplication.run(ItestEureka7001Application.class, args);
    }

}
