package com.gofar.kafka.consumer;

import com.gofar.kafka.producer.model.Client;
import com.gofar.kafka.producer.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.gofar.kafka.utils.Constants.CLIENT_TOPIC_NAME;
import static com.gofar.kafka.utils.Constants.PRODUCT_TOPIC_NAME;

@Service
public class ConsumerService {
    
    private final Logger log = LoggerFactory.getLogger(ConsumerService.class);

    @KafkaListener(topics = "product-topic", groupId = "demo-group")
    public void consumeProductData(Product data) {
        log.info("Consume product data :: {} from topic :: {}", data, PRODUCT_TOPIC_NAME);
    }

    @KafkaListener(topics = "client-topic", groupId = "demo-group")
    public void consumeClientData(Client data) {
        log.info("Consume client data :: {} from topic :: {}", data, CLIENT_TOPIC_NAME);
    }
}
