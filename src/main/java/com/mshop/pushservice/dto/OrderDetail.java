package com.mshop.pushservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail implements Serializable {
    private Long id;
    private int quantity;
    private double price;

    private Product product;

    private Order order;
}
