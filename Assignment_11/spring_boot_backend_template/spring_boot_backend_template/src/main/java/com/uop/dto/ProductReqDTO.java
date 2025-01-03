package com.uop.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ProductReqDTO {
	
	private String productName;

	private double price;

	private String desc;
	
	private boolean status;

	private int quantity;

}
