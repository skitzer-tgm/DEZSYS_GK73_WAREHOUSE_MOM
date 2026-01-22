package com.example.demo.model;

public class WarehouseStock {

    private String warehouseId;
    private String product;
    private int quantity;
    private long timestamp;

    public WarehouseStock() {}

    public WarehouseStock(String warehouseId, String product, int quantity) {
        this.warehouseId = warehouseId;
        this.product = product;
        this.quantity = quantity;
        this.timestamp = System.currentTimeMillis();
    }

    public String getWarehouseId() { return warehouseId; }
    public void setWarehouseId(String warehouseId) { this.warehouseId = warehouseId; }

    public String getProduct() { return product; }
    public void setProduct(String product) { this.product = product; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }
}
