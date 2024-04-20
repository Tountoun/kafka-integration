package com.gofar.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import static com.gofar.kafka.utils.Constants.*;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic productDataTopic() {
        return TopicBuilder.name(PRODUCT_TOPIC_NAME)
                .build();
    }

    @Bean
    public NewTopic clientDataTopic() {
        return TopicBuilder.name(CLIENT_TOPIC_NAME)
                .build();
    }
}
