package com.ecomm.gourav_e_comm.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecomm.gourav_e_comm.pojo.Customer;
import com.ecomm.gourav_e_comm.pojo.Item;

public interface IEcommRepo extends JpaRepository<Customer, Integer>{

	@Query(value = "Select NAME from ITEM i where i.ID=(Select ITEM_ID from CART c where c.id=(Select CART_ID from Customer where CUSTOMER_ID = ?1))", nativeQuery = true)
	String selectCartItems(int Id);

}
