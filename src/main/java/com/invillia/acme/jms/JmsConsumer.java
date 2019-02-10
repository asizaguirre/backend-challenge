package com.invillia.acme.jms;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.invillia.acme.domain.Store;
import com.invillia.acme.repositories.StoreRepository;

@Component
public class JmsConsumer {
	
	private StoreRepository storeRepository;

	@Autowired
	public void setStoreRepository(StoreRepository storeRepository) {
		this.storeRepository = storeRepository;
	}

	@JmsListener(destination = "queue.store")
	public void receive(Store store) {
		System.out.println("Recieved Message: " + store);
		List<Store> stores = new ArrayList<>();
		stores.add(store);
		for (Store p : stores) {
			storeRepository.save(p);
		}
	}
}
