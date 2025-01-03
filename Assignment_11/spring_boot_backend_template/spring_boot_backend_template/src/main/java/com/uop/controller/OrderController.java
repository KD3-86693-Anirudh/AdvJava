package com.uop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uop.dto.OrderResqDTO;
import com.uop.dto.OrderPlaceDTO;
import com.uop.dto.OrderRespDTO;
import com.uop.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/{userId}")
	
	public ResponseEntity<?> orderPlaced(@PathVariable Long userId , @RequestBody OrderPlaceDTO orderPlaceDTO){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(orderService.addOrder(userId, orderPlaceDTO));
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getAllorder(){
		
		List<OrderRespDTO> list=  orderService.getAll();
		
		if(list.isEmpty())
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id){
		
		List<OrderRespDTO> list = orderService.getById(id);
		
		if(list.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			
			return ResponseEntity.ok(list);
	}

}
