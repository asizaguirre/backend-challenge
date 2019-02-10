package com.invillia.acme.services;

import java.util.List;

public interface CRUDService<T> {
	void delete(Integer id);

	T getById(Integer id);

	List<?> listAll();

	T saveOrUpdate(T domainObject);
}
