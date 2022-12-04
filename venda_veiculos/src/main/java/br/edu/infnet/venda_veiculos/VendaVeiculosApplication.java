package br.edu.infnet.venda_veiculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class VendaVeiculosApplication {

    public static void main(String[] args) {
        SpringApplication.run(VendaVeiculosApplication.class, args);
    }


}
