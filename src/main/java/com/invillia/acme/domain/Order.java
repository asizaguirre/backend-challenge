package com.invillia.acme.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "TB_ORDER")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty()
	private Long id;
	@ApiModelProperty(notes = "Endereco da pessoa")
	private String address;
	@ApiModelProperty(notes = "Endereco da pessoa")
	private String confirmation;
	@ApiModelProperty(notes = "Endereco da pessoa")
	private Date date;
	@ApiModelProperty(notes = "Endereco da pessoa")
	private String status;
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	private OrderItem orderItem;

	@ManyToOne
	private Store store;

	public Order() {
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
	 * @return the confirmation
	 */
	public String getConfirmation() {
		return confirmation;
	}

	/**
	 * @param confirmation the confirmation to set
	 */
	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the orderItem
	 */
	public OrderItem getOrderItem() {
		return orderItem;
	}

	/**
	 * @param orderItem the orderItem to set
	 */
	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}

	/**
	 * @return the store
	 */
	public Store getStore() {
		return store;
	}

	/**
	 * @param store the store to set
	 */
	public void setStore(Store store) {
		this.store = store;
	}

	/**
	 * @param id
	 * @param address
	 * @param confirmation
	 * @param date
	 * @param status
	 * @param orderItem
	 * @param store
	 */
	public Order(Long id, String address, String confirmation, Date date, String status, OrderItem orderItem,
			Store store) {
		this.id = id;
		this.address = address;
		this.confirmation = confirmation;
		this.date = date;
		this.status = status;
		this.orderItem = orderItem;
		this.store = store;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((confirmation == null) ? 0 : confirmation.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((orderItem == null) ? 0 : orderItem.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((store == null) ? 0 : store.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (confirmation == null) {
			if (other.confirmation != null)
				return false;
		} else if (!confirmation.equals(other.confirmation))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (orderItem == null) {
			if (other.orderItem != null)
				return false;
		} else if (!orderItem.equals(other.orderItem))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (store == null) {
			if (other.store != null)
				return false;
		} else if (!store.equals(other.store))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [id=" + id + ", address=" + address + ", confirmation=" + confirmation + ", date=" + date
				+ ", status=" + status + ", orderItem=" + orderItem + ", store=" + store + "]";
	}

	
}
