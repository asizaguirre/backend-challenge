package com.invillia.acme.services;

import com.invillia.acme.domain.Order;
import com.invillia.acme.domain.OrderItem;
import com.invillia.acme.domain.Store;

public interface StoreService {

	void createStore(Store store);
	
	Store getStoreById(Integer id);

	void createOrder(Store store);

	void createOrderItem(Order order);

	void createPayment(OrderItem orderItem);

	Iterable<Store> listaStores();

	void sendStoreToQueue(Store store);
	//void sendOrderListToQueue(List<Store> stores);

}
