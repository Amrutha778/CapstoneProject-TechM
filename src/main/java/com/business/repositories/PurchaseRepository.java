package com.business.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.business.entities.Purchase;
import com.business.entities.Customer;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer>
{
	List<Purchase> findOrdersByUser(Customer user);
}
