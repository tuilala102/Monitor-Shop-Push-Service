package com.mshop.pushservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {
    private Long productId;
    private String name;
    private int quantity;
    private Double price;
    private Double discount;
    private String image;
    private String description;
    private Date enteredDate;
    private Boolean status;


}
