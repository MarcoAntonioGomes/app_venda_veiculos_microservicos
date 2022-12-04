package br.edu.infnet.compradores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CompradoresApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompradoresApplication.class, args);
    }

}
