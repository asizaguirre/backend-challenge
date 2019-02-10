package com.invillia.acme.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.acme.domain.Store;
import com.invillia.acme.services.StoreService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Model;

@Controller
@RestController
@RequestMapping("/store")
@Api(value = "stores")
public class StoreController {
	
	private StoreService storeService;

	@Autowired
	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}
	
	@ApiOperation(value = "Adiciona stores na fila")
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> addStore(@RequestBody Store store) {
		storeService.sendStoreToQueue(store);;
		return new ResponseEntity<String>("Store saved successfully", HttpStatus.OK);
	}

	
	@ApiOperation(value = "Search a Stores with an ID", response = Store.class)
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = "application/json")
	public Store showPessoa(@PathVariable Integer id, Model model) {
		Store store = storeService.getStoreById(id);
		return store;
	}


}
