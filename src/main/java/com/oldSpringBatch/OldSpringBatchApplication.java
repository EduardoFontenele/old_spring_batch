package com.oldSpringBatch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class OldSpringBatchApplication {


	public static void main(String[] args) {
		SpringApplication.run(OldSpringBatchApplication.class, args);

	}

}
