package com.uop.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="orders")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class Order extends BaseEntity {
	
	@Column(length = 30)
	private double totalAmount;
	
	@Column(length = 30)
	private int qty;
	
	@ManyToOne
	@JoinColumn(name="userId", nullable = false)
	private User userId;
	
	@ManyToOne
	@JoinColumn(name="productId", nullable = false)
	private Product productid;
	
}
