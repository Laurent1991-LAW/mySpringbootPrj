package org.lwason.sbprj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(scanBasePackages = "org.lwason.sbprj.*")
public class SbprjApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbprjApplication.class, args);
    }

}
