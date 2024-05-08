package com.mshop.pushservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable{
	private Long id;
	private Double amount;
	private String address;
	private String phone;
	private Date orderDate;
	private int status;
	private Long userId;
	private User user;
}
