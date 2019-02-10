package com.invillia.acme.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.invillia.acme.domain.OrderItem;;

@RepositoryRestResource
public interface OrderItemRepository extends CrudRepository<OrderItem, Integer> {

}
