package com.invillia.acme.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invillia.acme.domain.OrderItem;
import com.invillia.acme.repositories.OrderItemRepository;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	private OrderItemRepository orderItemRepository;

	@Autowired
	public void setOrderItemRepository(OrderItemRepository orderItemRepository) {
		this.orderItemRepository = orderItemRepository;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		orderItemRepository.deleteById(id);
	}

	@Override
	public OrderItem getById(Integer id) {
		// TODO Auto-generated method stub
		return orderItemRepository.findById(id).orElse(null);
	}

	@Override
	public List<?> listAll() {
		// TODO Auto-generated method stub
		return (List<?>) orderItemRepository.findAll();
	}

	@Override
	public OrderItem saveOrUpdate(OrderItem domainObject) {
		// TODO Auto-generated method stub
		return orderItemRepository.save(domainObject);
	}

}
