package com.uop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.uop.dto.ProductReqDTO;
import com.uop.dto.ProductRespDTO;
import com.uop.service.ProductService;
import com.uop.service.UserService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/{id}")
	public ResponseEntity<?> addProduct(@RequestBody ProductReqDTO dto, @PathVariable Long id){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(dto, id));
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getProducts(){
		
		List<ProductRespDTO> products= productService.getAllProduct();
	
		if(products.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		return ResponseEntity.ok(products);
	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long id, @RequestParam Long userId){
		
		return ResponseEntity.status(HttpStatus.OK).body(productService.deleteProduct(id, userId));
	}
}
