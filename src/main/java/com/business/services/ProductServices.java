package com.business.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.business.entities.Item;
import com.business.repositories.ItemRepository;
@Component
public class ProductServices 
{
	@Autowired
	private ItemRepository productRepository;

	//add Product
	public void addProduct(Item p)
	{
		this.productRepository.save(p);
	}


	//getAll products
	public List<Item> getAllProducts()
	{
		List<Item> products=(List<Item>)this.productRepository.findAll();
		return products;
	}

	//get Single Product
	public Item getProduct(int id)
	{
		Optional<Item> optional = this.productRepository.findById(id);
		Item product=optional.get();
		return product;
	}

	//update Product
	public void updateproduct(Item p,int id)
	{
		p.setPid(id);
		Optional<Item> optional = this.productRepository.findById(id);
		Item prod=optional.get();

		if(prod.getPid()==id)
		{
			this.productRepository.save(p);				
		}
	}
	//delete product
	public void deleteProduct(int id)
	{
		this.productRepository.deleteById(id);
	}

	//Get Product By Name
	public Item getProductByName(String name)
	{
		
		Item product= this.productRepository.findByPname(name);
		if(product!=null)
		{
			return product;
		}
		return null;
	
	}
}