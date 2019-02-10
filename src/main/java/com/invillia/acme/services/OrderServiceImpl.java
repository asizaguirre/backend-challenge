package com.invillia.acme.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invillia.acme.domain.Order;
import com.invillia.acme.repositories.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	private OrderRepository orderRepository;

	@Autowired
	public void setOrderRepository(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		orderRepository.deleteById(id);
	}

	@Override
	public Order getById(Integer id) {
		// TODO Auto-generated method stub
		return orderRepository.findById(id).orElse(null);
	}

	@Override
	public List<?> listAll() {
		// TODO Auto-generated method stub
		return (List<?>) orderRepository.findAll();
	}

	@Override
	public Order saveOrUpdate(Order domainObject) {
		// TODO Auto-generated method stub
		return orderRepository.save(domainObject);
	}

}
