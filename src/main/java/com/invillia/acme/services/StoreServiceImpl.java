package com.invillia.acme.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invillia.acme.domain.Order;
import com.invillia.acme.domain.OrderItem;
import com.invillia.acme.domain.Store;
import com.invillia.acme.jms.JmsProducer;
import com.invillia.acme.repositories.StoreRepository;

@Service
public class StoreServiceImpl implements StoreService {
	//TODO implementar metodos para incluir order, order itens e payments
	private JmsProducer jmsProduce;
	
	private StoreRepository storeRepository;

	@Autowired
	public void setJmsProduce(JmsProducer jmsProduce) {
		this.jmsProduce = jmsProduce;
	}

	@Autowired
	public void setStoreRepository(StoreRepository storeRepository) {
		this.storeRepository = storeRepository;
	}

	
	
	@Override
	public void createPayment(OrderItem orderItem) {
		// TODO Auto-generated method stub
//		storeRepository.createPayment(orderItem);

	}

	@Override
	public Iterable<Store> listaStores() {
		// TODO Auto-generated method stub
		return storeRepository.findAll();
	}

	@Override
	public Store getStoreById(Integer id) {
		// TODO Auto-generated method stub
		return storeRepository.findById(id).orElse(null);
	}

	@Override
	public void sendStoreToQueue(Store store) {
		// TODO Auto-generated method stub
		jmsProduce.sendToQueue(store);
	}

	@Override
	public void createStore(Store store) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createOrder(Store store) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createOrderItem(Order order) {
		// TODO Auto-generated method stub
		
	}

}
