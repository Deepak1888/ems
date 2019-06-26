package com.globant.EMS.model;

import javax.persistence.Embeddable;

@Embeddable
public class UserProductPK extends UserProduct {

	private static final long serialVersionUID = 1L;

	private int userId;
	
	private int productId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + productId;
		result = prime * result + userId;
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
		UserProductPK other = (UserProductPK) obj;
		if (productId != other.productId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	
	
	
}
