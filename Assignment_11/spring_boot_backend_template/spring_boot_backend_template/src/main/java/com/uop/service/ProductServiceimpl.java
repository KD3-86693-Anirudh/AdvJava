package com.uop.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uop.dao.ProductDao;
import com.uop.dao.UserDao;
import com.uop.dto.ProductReqDTO;
import com.uop.dto.ProductRespDTO;
import com.uop.pojos.Product;
import com.uop.pojos.User;
import com.uop.pojos.UserRole;

@Service
@Transactional
public class ProductServiceimpl implements ProductService{

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ModelMapper model;
	
	@Autowired
	private UserDao userDao;

	public ProductServiceimpl() {
		super();
	}

	@Override
	public String addProduct(ProductReqDTO prod, Long userId) {
		
		User u = userDao.findById(userId).orElseThrow();
		
		if(u.getRole().equals(UserRole.ADMIN)) {
		Product product = model.map(prod, Product.class);
		
		productDao.save(product);
		return "saved successfully";
		}
		return "Not added";
	}

	@Override
	public List<ProductRespDTO> getAllProduct() {
		
		return productDao.findByStatusTrue().stream().map(product -> model.map(product, ProductRespDTO.class)).collect(Collectors.toList());
	}

	@Override
	public String deleteProduct(Long id , Long userId) {
		User u = userDao.findById(userId).orElseThrow();
		
		if(u.getRole().equals(UserRole.ADMIN)) {
		Product product = productDao.findById(id).orElseThrow();
		
		product.setStatus(false);
		
		productDao.save(product);
		return "deleted successfully";
		}
		return "Not deleted";
	}
}
	
	

