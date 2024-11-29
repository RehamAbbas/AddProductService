package com.example.AddProductService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
// import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AddProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddProductServiceApplication.class, args);
	}

}
