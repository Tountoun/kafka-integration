package com.gofar.kafka.producer;

import com.gofar.kafka.utils.TopData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.gofar.kafka.utils.Constants.TOPIC_NAME;

@Service
public class ProducerService {
    private final Logger log = LoggerFactory.getLogger(ProducerService.class);

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void publishData(Object data) {
        log.debug("===== Start publishing data {}=====", data.toString());
        kafkaTemplate.send(TOPIC_NAME, data);
        log.debug("===== End publishing data {}=====", data.toString());
    }

}
