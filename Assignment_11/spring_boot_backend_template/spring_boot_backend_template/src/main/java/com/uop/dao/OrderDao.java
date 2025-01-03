package com.uop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uop.dto.OrderResqDTO;
import com.uop.pojos.Order;
import com.uop.pojos.User;

public interface OrderDao extends JpaRepository<Order, Long>{

	List<Order> findByUserId(User user);

}
