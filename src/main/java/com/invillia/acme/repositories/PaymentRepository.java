package com.invillia.acme.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.invillia.acme.domain.Payment;

@RepositoryRestResource
public interface PaymentRepository extends CrudRepository<Payment, Integer>{

}
