package com.example.demo;

import com.example.demo.model.WarehouseStock;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    private final MessageProducer producer;

    public WarehouseController(MessageProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/send")
    public String sendStock(@RequestBody WarehouseStock stock) throws Exception {
        producer.sendStock(stock);
        return "SENT";
    }
}
