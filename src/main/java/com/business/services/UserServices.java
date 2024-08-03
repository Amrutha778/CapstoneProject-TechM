package com.business.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.business.entities.Admin;
import com.business.entities.Customer;
import com.business.repositories.CustomerRepository;
@Component
public class UserServices 
{
	@Autowired
	private CustomerRepository userRepository;
		
	//Get All Users
	public List<Customer> getAllUser()
	{
		List<Customer> users = (List<Customer>) this.userRepository.findAll();
		return users;
	}
	
	//Get Single User
	public Customer getUser(int id)
	{
		Optional<Customer> optional = this.userRepository.findById(id);
		Customer user = optional.get();
		return user;
	}
	
	//Get Single User By Email
	public Customer getUserByEmail(String email)
	{
	 Customer user=	this.userRepository.findUserByUemail(email);
	 return user;
	}
	
	//Update
	public void updateUser(Customer user,int id)
	{
		user.setU_id(id);
		 this.userRepository.save(user);
	}
	
	//delete single User
	public void deleteUser(int id)
	{
		this.userRepository.deleteById(id);
	}

	//Add User
	public void addUser(Customer user)
	{
	this.userRepository.save(user);
	}
	
	public boolean validateLoginCredentials(String email,String password)
	{
		List<Customer> users = (List<Customer>) this.userRepository.findAll();
		for(Customer u:users)
		{
		if(u!=null && u.getUpassword().equals(password) && u.getUemail().equals(email))
		{
			return true;
		}
		}
		return false;
	}
	
	

}
