package com.example.demo;

import com.example.demo.model.WarehouseStock;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class MessageConsumer {

    private final ObjectMapper mapper = new ObjectMapper();
    private final KafkaTemplate<String, String> kafkaTemplate;

    private final Map<String, WarehouseStock> latestStocks = new ConcurrentHashMap<>();

    public MessageConsumer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "${warehouse.topics.stock}")
    public void receive(String message) throws Exception {
        WarehouseStock stock = mapper.readValue(message, WarehouseStock.class);

        System.out.println("RECEIVED FROM " + stock.getWarehouseId() + ": " + message);

        latestStocks.put(stock.getWarehouseId(), stock);

        kafkaTemplate.send("warehouse-response", stock.getWarehouseId(), "SUCCESS");
    }

    public Map<String, WarehouseStock> getAllStocks() {
        return latestStocks;
    }
}
