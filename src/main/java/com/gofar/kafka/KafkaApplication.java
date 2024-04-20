package com.gofar.kafka;

import com.gofar.kafka.producer.ProducerService;
import com.gofar.kafka.producer.controller.ClientController;
import com.gofar.kafka.producer.controller.ProductController;
import com.gofar.kafka.producer.model.Client;
import com.gofar.kafka.producer.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}


	@Bean
	ApplicationRunner runner() {
		return args -> {
			Product product = new Product();
			product.setId(6L);
			product.setQuantity(65);
			product.setName("Gaz");
			product.setReference("32TTZ");

			Client client = new Client();
			client.setCin("642T2TRT");
			client.setLastName("Igoe");
			client.setFirstName("Sam");

			producerService.publishProductData(product);
			producerService.publishClientData(client);
		};
	}

	@Autowired
	private ProducerService producerService;

}
