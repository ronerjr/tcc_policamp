package com.onfocus.jfood.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The persistent class for the complements database table.
 * 
 */
@Entity
@Table(name = "complements")
public class Complement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "active")
	private Boolean active;

	@Column(name = "additional_value")
	private BigDecimal additionalValue;

	@Column(name = "complement")
	private String complement;

	// bi-directional many-to-one association to ProductType
	@ManyToOne
	@JoinColumn(name = "id_product_type")
	private ProductType productType;

	public Complement() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public BigDecimal getAdditionalValue() {
		return this.additionalValue;
	}

	public void setAdditionalValue(BigDecimal additionalValue) {
		this.additionalValue = additionalValue;
	}

	public String getComplement() {
		return this.complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public ProductType getProductType() {
		return this.productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((additionalValue == null) ? 0 : additionalValue.hashCode());
		result = prime * result + ((complement == null) ? 0 : complement.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((productType == null) ? 0 : productType.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Complement other = (Complement) obj;
		if (active == null) {
			if (other.active != null) {
				return false;
			}
		} else if (!active.equals(other.active)) {
			return false;
		}
		if (additionalValue == null) {
			if (other.additionalValue != null) {
				return false;
			}
		} else if (!additionalValue.equals(other.additionalValue)) {
			return false;
		}
		if (complement == null) {
			if (other.complement != null) {
				return false;
			}
		} else if (!complement.equals(other.complement)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (productType == null) {
			if (other.productType != null) {
				return false;
			}
		} else if (!productType.equals(other.productType)) {
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Complement [id=" + id + ", active=" + active + ", additionalValue=" + additionalValue + ", complement="
				+ complement + ", productType=" + productType + "]";
	}

}