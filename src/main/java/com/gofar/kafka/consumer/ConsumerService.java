package com.gofar.kafka.consumer;

import com.gofar.kafka.producer.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.gofar.kafka.utils.Constants.PRODUCT_TOPIC_NAME;

@Service
public class ConsumerService {
    
    private final Logger log = LoggerFactory.getLogger(ConsumerService.class);

    @KafkaListener(topics = "product-topic", groupId = "demo-group")
    public void consumeProductData(Product data) {
        log.info("Consume data from Kafka topic :: {}, and content is :: {}", PRODUCT_TOPIC_NAME, data.toString());
    }
}
