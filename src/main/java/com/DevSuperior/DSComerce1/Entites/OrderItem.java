package com.DevSuperior.DSComerce1.Entites;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_OrderItem")
public class OrderItem {
    @EmbeddedId
    private OrderItemPK id= new OrderItemPK();
    private Integer Quantity;
    private Double price;

    public OrderItem() {
    }

    public OrderItem(Order order, Product  product , Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.Quantity=quantity;
        this.price = price;
    }

    public Order getOrder() {
        return id.getOrder();
    }
    public void setOrder(Order order) {
        id.setOrder(order);
    }
    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    public Product getProduct() {
        return id.getProduct();
    }

    public void setProduct(Product product) {
        id.setProduct(product);
    }
}
