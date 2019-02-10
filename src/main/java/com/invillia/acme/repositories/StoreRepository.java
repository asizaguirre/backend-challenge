package com.invillia.acme.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.invillia.acme.domain.Order;
import com.invillia.acme.domain.OrderItem;
import com.invillia.acme.domain.Store;

	

@RepositoryRestResource
public interface StoreRepository extends CrudRepository<Store, Integer>{


//	void createStore(Store store);

//	void createOrder(Store store);

//	void createOrderItem(Order order);

//	void createPayment(OrderItem orderItem);

	
	

}
