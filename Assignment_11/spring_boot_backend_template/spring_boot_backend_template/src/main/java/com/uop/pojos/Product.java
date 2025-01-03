package com.uop.pojos;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name="products")
@ToString(callSuper = true)
public class Product extends BaseEntity {
	@Column(name = "product_name", length = 20)
	private String productName;
	@Column(length = 20)
	private double price;
	@Column(length = 20)
	private String description;
	private boolean status;
	@Column(length = 20)
	private int quantity;
}
