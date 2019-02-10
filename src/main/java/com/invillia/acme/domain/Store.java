package com.invillia.acme.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "TB_STORE")
public class Store {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty()
	private Long id;
	@ApiModelProperty(notes = "The product description")
	private String name;
	@ApiModelProperty(notes = "The product description")
	private String address;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "store", orphanRemoval = true)
	private List<Order> orders = new ArrayList<>();

	public Store() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the orders
	 */
	public List<Order> getOrders() {
		return orders;
	}

	/**
	 * @param orders the orders to set
	 */
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	/**
	 * @param id
	 * @param name
	 * @param address
	 * @param orders
	 */
	public Store(Long id, String name, String address, List<Order> orders) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.orders = orders;
	}

}
