package com.invillia.acme.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.invillia.acme.domain.Order;

@RepositoryRestResource
public interface OrderRepository extends CrudRepository<Order, Integer> {


}
