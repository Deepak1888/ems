package com.globant.EMS.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the user_product database table.
 * 
 */
@Entity
@Table(name="user_product")
@NamedQuery(name="UserProduct.findAll", query="SELECT u FROM UserProduct u")
public class UserProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserProductPK id;

	public UserProduct() {
	}

	public UserProductPK getId() {
		return this.id;
	}

	public void setId(UserProductPK id) {
		this.id = id;
	}

}