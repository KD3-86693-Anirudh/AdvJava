package com.uop.dto;

import com.uop.pojos.Product;
import com.uop.pojos.User;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class OrderResqDTO {
	
	private double totalAmount;

	private int qty;
	
	private Long userId;
	
	private Long productid;

}
