package com.invillia.acme.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "TB_ORDER")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty()
	private Integer id;

	@ApiModelProperty(notes = "Endereco da pessoa")
	private String address;
	@ApiModelProperty(notes = "Endereco da pessoa")
	private String confirmation;
	@ApiModelProperty(notes = "Endereco da pessoa")
	private Date date;
	@ApiModelProperty(notes = "Endereco da pessoa")
	private String status;

	@ApiModelProperty(notes = "Id da store que será setada pela fila")
	private Integer storeId;

	public Order() {
		// TODO Auto-generated constructor stub
		super();
	}

//	public Order(Integer id2, OrderDTO o) {
//		// TODO Auto-generated constructor stub
//		this.storeId = id2;
//		this.address = o.getAddress() == null ? "" : o.getAddress();
//		this.confirmation = o.getConfirmation() == null ? "" : o.getConfirmation();
//		this.date = o.getDate() == null ? null : o.getDate();
//		this.status = o.getStatus() == null ? "" : o.getStatus();
//
//	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((confirmation == null) ? 0 : confirmation.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

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
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", address=" + address + ", confirmation=" + confirmation + ", date=" + date
				+ ", status=" + status + "]";
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

}
