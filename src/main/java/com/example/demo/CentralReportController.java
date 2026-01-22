package com.example.demo;

import com.example.demo.model.WarehouseStock;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class CentralReportController {

    private final MessageConsumer consumer;

    public CentralReportController(MessageConsumer consumer) {
        this.consumer = consumer;
    }

    @GetMapping("/warehouse/report")
    public Collection<WarehouseStock> report() {
        return consumer.getAllStocks().values();
    }
}
