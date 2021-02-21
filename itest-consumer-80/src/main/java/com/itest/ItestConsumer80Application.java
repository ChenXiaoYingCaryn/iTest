package com.itest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.itest"})
public class ItestConsumer80Application {

    public static void main(String[] args) {
        SpringApplication.run(ItestConsumer80Application.class, args);
    }

}
