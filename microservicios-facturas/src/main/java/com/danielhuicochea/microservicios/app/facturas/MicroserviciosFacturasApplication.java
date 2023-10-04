package com.danielhuicochea.microservicios.app.facturas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@EntityScan({ "com.danielhuicochea.microservicios.app.facturas.models.entity" })
public class MicroserviciosFacturasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosFacturasApplication.class, args);
	}

}
