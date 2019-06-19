package com.karen.solrcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SolrcloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SolrcloudApplication.class, args);
    }

}
