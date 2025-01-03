package com.uop.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uop.dao.UserDao;
import com.uop.dto.UserDTO;
import com.uop.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModelMapper model;
	
	

	public UserServiceImpl() {
		super();
	}



	@Override
	public String addUser(UserDTO user) {
			
		try {
			User u = model.map(user, User.class);
			userDao.save(u);
		return "Ho gaya bhai save";
		}catch (Exception e) {
			return "Still remaining";
			}
		
	}
	
	

}
