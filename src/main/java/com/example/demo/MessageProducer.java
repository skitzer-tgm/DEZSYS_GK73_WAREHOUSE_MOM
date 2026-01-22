package com.example.demo;

import com.example.demo.model.WarehouseStock;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper mapper = new ObjectMapper();

    @Value("${warehouse.topics.stock}")
    private String stockTopic;

    public MessageProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendStock(WarehouseStock stock) throws Exception {
        String json = mapper.writeValueAsString(stock);
        kafkaTemplate.send(stockTopic, stock.getWarehouseId(), json);
    }
}
