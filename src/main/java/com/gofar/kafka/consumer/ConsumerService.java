package com.gofar.kafka.consumer;

import com.gofar.kafka.utils.TopData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.gofar.kafka.utils.Constants.TOPIC_NAME;

@Service
public class ConsumerService {
    
    private final Logger log = LoggerFactory.getLogger(ConsumerService.class);

    @KafkaListener(topics = "demo-topic", groupId = "demo-group")
    public void consumeData(Object data) {
        log.info("Consume data from Kafka topic :: {}, and content is :: {}", TOPIC_NAME, data);
    }
}
