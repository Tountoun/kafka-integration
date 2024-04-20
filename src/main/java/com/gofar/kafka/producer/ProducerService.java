package com.gofar.kafka.producer;

import com.gofar.kafka.producer.model.Client;
import com.gofar.kafka.producer.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import static com.gofar.kafka.utils.Constants.*;

@Service
public class ProducerService {
    private final Logger log = LoggerFactory.getLogger(ProducerService.class);

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void publishProductData(Product data) {
        log.debug("===== Start publishing product data {}=====", data.toString());
        Message<Product> productMessage = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, PRODUCT_TOPIC_NAME)
                .build();
        CompletableFuture<SendResult<String, Object>> completableFuture = kafkaTemplate.send(productMessage);
        completableFuture.whenComplete((result, throwable) -> {
            if (Objects.isNull(throwable)) {
                log.info("Product data published successfully to partition {} of topic {}", result.getRecordMetadata().partition(), result.getProducerRecord().topic());
            } else {
                log.error("Error in publishing data: {}", throwable.getLocalizedMessage());
            }
        });
        log.debug("===== End publishing product data {}=====", data.toString());
    }

    public void publishClientData(Client data) {
        log.debug("===== Start publishing product data {}=====", data.toString());
        Message<Client> productMessage = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, CLIENT_TOPIC_NAME)
                .build();
        CompletableFuture<SendResult<String, Object>> completableFuture = kafkaTemplate.send(productMessage);
        completableFuture.whenComplete((result, throwable) -> {
            if (Objects.isNull(throwable)) {
                log.info("Client data published successfully to partition {} of topic {}", result.getRecordMetadata().partition(), result.getProducerRecord().topic());
            } else {
                log.error("Error in publishing data: {}", throwable.getLocalizedMessage());
            }
        });
        log.debug("===== End publishing product data {}=====", data.toString());
    }

}
