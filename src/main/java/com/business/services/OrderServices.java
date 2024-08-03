package com.business.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.business.entities.Purchase;
import com.business.entities.Customer;
import com.business.repositories.PurchaseRepository;
@Component
public class OrderServices
{
	@Autowired
	private PurchaseRepository orderRepository;

	//get all orders
	public List<Purchase> getOrders()
	{
		List<Purchase> list=this.orderRepository.findAll();
		return list;
	}
	//save Order
	public void saveOrder(Purchase order)
	{
		this.orderRepository.save(order);
	}
	
	//update order
	public void updateOrder(int id,Purchase order)
	{
		order.setoId(id);
		this.orderRepository.save(order);
		 
	}
	
	//delete order
	public void deleteOrder(int id)
	{
		this.orderRepository.deleteById(id);
	}
	
	//get Order history of user
	public List<Purchase> getOrdersForUser(Customer user)
	{
	 return  this.orderRepository.findOrdersByUser(user);
	}
	
}
