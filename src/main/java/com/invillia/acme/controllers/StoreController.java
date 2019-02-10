package com.invillia.acme.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.acme.domain.Order;
import com.invillia.acme.domain.OrderItem;
import com.invillia.acme.domain.Store;
import com.invillia.acme.services.OrderItemService;
import com.invillia.acme.services.OrderService;
import com.invillia.acme.services.StoreService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Model;

@Controller
@RestController
@RequestMapping("/store")
@Api(value = "store")
public class StoreController {

	private StoreService storeService;
	private OrderService orderService;
	private OrderItemService orderItemService;

	@Autowired
	public void setOrderItemService(OrderItemService orderItemService) {
		this.orderItemService = orderItemService;
	}

	@Autowired
	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}

	@Autowired
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	@ApiOperation(value = "Adiciona stores ")
	@RequestMapping(value = "/create/store", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> addStore(@RequestBody Store store) {
		storeService.saveOrUpdate(store);
		return new ResponseEntity<String>("Store criada  ", HttpStatus.OK);
	}

	@ApiOperation(value = "Adiciona Order, se faz necessário informar uma ID de Store ")
	@RequestMapping(value = "/create/order/{sotreId}", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> addOrder(@PathVariable Integer sotreId, @RequestBody Order order) {
		if (storeService.getById(sotreId) != null) {
			order.setStoreId(sotreId);
			orderService.saveOrUpdate(order);
			return new ResponseEntity<String>("Order criada  ", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Store ID não encontrada  ", HttpStatus.NOT_ACCEPTABLE);
	}

	@ApiOperation(value = "Adiciona Order Itens, será necessário informar uma ID de ORDER! ")
	@RequestMapping(value = "/create/orderItens/{orderId}", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> addOrderItens(@PathVariable Integer orderId, @RequestBody OrderItem orderItens) {
		if (orderService.getById(orderId) != null) {
			orderItemService.saveOrUpdate(orderItens);
			return new ResponseEntity<String>("OrderIten criada  ", HttpStatus.OK);
		}

		return new ResponseEntity<String>("ID de Order não encontrado  ", HttpStatus.NOT_ACCEPTABLE);
	}

	@ApiOperation(value = "Lista as Stores cadastradas", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list: http://localhost:8080/actuator/health"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "/list/stores", method = RequestMethod.GET, produces = "application/json")
	public List<?> list(Model model) {
		List<?> storeList = storeService.listAll();
		return storeList;
	}

	@ApiOperation(value = "Lista as Order cadastradas", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@RequestMapping(value = "/list/orders", method = RequestMethod.GET, produces = "application/json")
	public List<?> listOrder(Model model) {
		List<?> orderList = orderService.listAll();
		return orderList;
	}

	@ApiOperation(value = "Search a Orderes b ID", response = Store.class)
	@RequestMapping(value = "/show/order/{id}", method = RequestMethod.GET, produces = "application/json")
	public Order showOrders(@PathVariable Integer id, Model model) {
		Order order = orderService.getById(id);
		return order;
	}

	@ApiOperation(value = "Search a Store b ID", response = Store.class)
	@RequestMapping(value = "/show/store/{id}", method = RequestMethod.GET, produces = "application/json")
	public Store showStores(@PathVariable Integer id, Model model) {
		Store store = storeService.getById(id);
		return store;
	}

}
