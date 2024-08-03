package com.business.repositories;

import org.springframework.data.repository.CrudRepository;

import com.business.entities.Admin;
import com.business.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer,Integer>
{
public Customer findUserByUemail(String email);
}
