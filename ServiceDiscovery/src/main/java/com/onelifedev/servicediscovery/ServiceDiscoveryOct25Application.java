package com.onelifedev.servicediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceDiscoveryOct25Application {

    public static void main(String[] args) {
        SpringApplication.run(ServiceDiscoveryOct25Application.class, args);
    }

}
