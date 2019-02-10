package com.invillia.acme.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invillia.acme.domain.Store;
import com.invillia.acme.repositories.StoreRepository;

@Service
public class StoreServiceImpl implements StoreService {
	private StoreRepository storeRepository;

	@Autowired
	public void setStoreRepository(StoreRepository storeRepository) {
		this.storeRepository = storeRepository;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		storeRepository.deleteById(id);
	}

	@Override
	public Store getById(Integer id) {
		// TODO Auto-generated method stub
		return storeRepository.findById(id).orElse(null);
	}

	@Override
	public List<?> listAll() {
		// TODO Auto-generated method stub
		return (List<?>) storeRepository.findAll();
	}

	@Override
	public Store saveOrUpdate(Store domainObject) {
		// TODO Auto-generated method stub
		return storeRepository.save(domainObject);
	}

//	@Override
//	public void sendToQueue(StoreDTO str) {
//		// TODO Auto-generated method stub
//		jmsProduce.sendToQueue(str);
//	}
//
//	@Override
//	public void sendToTopic(StoreDTO str) {
//		// TODO Auto-generated method stub
//		jmsProduce.sendToTopic(str);
//	}

}
