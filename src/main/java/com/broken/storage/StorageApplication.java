package com.broken.storage;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;


@OpenAPIDefinition(
		servers={
				@Server(url = "http://localhost:8080/",description = "localDev"),

		},

		info = @Info(
				title="StorageAPI",
				version = "0.1",
				description = "StorageServices"
		)
)
@SpringBootApplication
public class StorageApplication {

	public static void main(String[] args) {
		SpringApplication.run(StorageApplication.class, args);

		System.out.println(LocalDateTime.MIN);

	}

}
