package com.globant.EMS.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int productId;

	private int description;

	private int endDate;

	private int price;

	private int productName;

	private int startDate;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="products")
	private List<User> users;

	public Product() {
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getDescription() {
		return this.description;
	}

	public void setDescription(int description) {
		this.description = description;
	}

	public int getEndDate() {
		return this.endDate;
	}

	public void setEndDate(int endDate) {
		this.endDate = endDate;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getProductName() {
		return this.productName;
	}

	public void setProductName(int productName) {
		this.productName = productName;
	}

	public int getStartDate() {
		return this.startDate;
	}

	public void setStartDate(int startDate) {
		this.startDate = startDate;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}