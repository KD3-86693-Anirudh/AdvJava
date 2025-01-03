package com.uop.pojos;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name="users")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class User extends BaseEntity {
	@Column(name = "first_name", length = 30)
	private String firstName;
	@Column(name = "last_name", length = 25) 
	private String lastName;
	@Enumerated(EnumType.STRING)
	@Column(length = 10) 
	private UserRole role;
	
}
