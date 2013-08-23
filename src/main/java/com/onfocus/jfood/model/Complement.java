package com.onfocus.jfood.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the complements database table.
 * 
 */
@Entity
@Table(name="complements")
public class Complement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;

	private Boolean active;

	@Column(name="additional_value", nullable=false, precision=2)
	private BigDecimal additionalValue;

	@Column(nullable=false, length=255)
	private String complement;

	//bi-directional many-to-one association to ProductType
    @ManyToOne
	@JoinColumn(name="id_product_type")
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
	
}