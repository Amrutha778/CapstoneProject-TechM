package com.business.repositories;

import org.springframework.data.repository.CrudRepository;

import com.business.entities.Item;

public interface ItemRepository extends CrudRepository<Item,Integer>
{
	public Item findByPname(String name);

}
