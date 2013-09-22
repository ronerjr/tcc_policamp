package com.onfocus.jfood.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the orders database table.
 * 
 */
@Entity
@Table(name = "orders")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "change_value")
	private BigDecimal changeValue;

	@Temporal(TemporalType.DATE)
	@Column(name = "close_date")
	private Date closeDate;

	@Column(name = "discount")
	private BigDecimal discount;

	@Column(name = "id_customer")
	private Long idCustomer;

	@Column(name = "id_table")
	private Long idTable;

	@Temporal(TemporalType.DATE)
	@Column(name = "open_date")
	private Date openDate;

	@Column(name = "received_value")
	private BigDecimal receivedValue;

	@Column(name = "s_observacao")
	private String sObservacao;

	@Column(name = "total_value")
	private BigDecimal totalValue;

	// bi-directional many-to-one association to OrderStatus
	@ManyToOne
	@JoinColumn(name = "id_status")
	private OrderStatus orderStatus;

	// bi-directional many-to-one association to ProductType
	@ManyToOne
	@JoinColumn(name = "id_payment_mode")
	private ProductType productType;

	// bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name = "id_product")
	private Product product;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;

	public Order() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getChangeValue() {
		return this.changeValue;
	}

	public void setChangeValue(BigDecimal changeValue) {
		this.changeValue = changeValue;
	}

	public Date getCloseDate() {
		return this.closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public BigDecimal getDiscount() {
		return this.discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public Long getIdCustomer() {
		return this.idCustomer;
	}

	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}

	public Long getIdTable() {
		return this.idTable;
	}

	public void setIdTable(Long idTable) {
		this.idTable = idTable;
	}

	public Date getOpenDate() {
		return this.openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public BigDecimal getReceivedValue() {
		return this.receivedValue;
	}

	public void setReceivedValue(BigDecimal receivedValue) {
		this.receivedValue = receivedValue;
	}

	public String getSObservacao() {
		return this.sObservacao;
	}

	public void setSObservacao(String sObservacao) {
		this.sObservacao = sObservacao;
	}

	public BigDecimal getTotalValue() {
		return this.totalValue;
	}

	public void setTotalValue(BigDecimal totalValue) {
		this.totalValue = totalValue;
	}

	public OrderStatus getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public ProductType getProductType() {
		return this.productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
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
		result = prime * result + ((changeValue == null) ? 0 : changeValue.hashCode());
		result = prime * result + ((closeDate == null) ? 0 : closeDate.hashCode());
		result = prime * result + ((discount == null) ? 0 : discount.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idCustomer == null) ? 0 : idCustomer.hashCode());
		result = prime * result + ((idTable == null) ? 0 : idTable.hashCode());
		result = prime * result + ((openDate == null) ? 0 : openDate.hashCode());
		result = prime * result + ((orderStatus == null) ? 0 : orderStatus.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((productType == null) ? 0 : productType.hashCode());
		result = prime * result + ((receivedValue == null) ? 0 : receivedValue.hashCode());
		result = prime * result + ((sObservacao == null) ? 0 : sObservacao.hashCode());
		result = prime * result + ((totalValue == null) ? 0 : totalValue.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Order other = (Order) obj;
		if (changeValue == null) {
			if (other.changeValue != null) {
				return false;
			}
		} else if (!changeValue.equals(other.changeValue)) {
			return false;
		}
		if (closeDate == null) {
			if (other.closeDate != null) {
				return false;
			}
		} else if (!closeDate.equals(other.closeDate)) {
			return false;
		}
		if (discount == null) {
			if (other.discount != null) {
				return false;
			}
		} else if (!discount.equals(other.discount)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (idCustomer == null) {
			if (other.idCustomer != null) {
				return false;
			}
		} else if (!idCustomer.equals(other.idCustomer)) {
			return false;
		}
		if (idTable == null) {
			if (other.idTable != null) {
				return false;
			}
		} else if (!idTable.equals(other.idTable)) {
			return false;
		}
		if (openDate == null) {
			if (other.openDate != null) {
				return false;
			}
		} else if (!openDate.equals(other.openDate)) {
			return false;
		}
		if (orderStatus == null) {
			if (other.orderStatus != null) {
				return false;
			}
		} else if (!orderStatus.equals(other.orderStatus)) {
			return false;
		}
		if (product == null) {
			if (other.product != null) {
				return false;
			}
		} else if (!product.equals(other.product)) {
			return false;
		}
		if (productType == null) {
			if (other.productType != null) {
				return false;
			}
		} else if (!productType.equals(other.productType)) {
			return false;
		}
		if (receivedValue == null) {
			if (other.receivedValue != null) {
				return false;
			}
		} else if (!receivedValue.equals(other.receivedValue)) {
			return false;
		}
		if (sObservacao == null) {
			if (other.sObservacao != null) {
				return false;
			}
		} else if (!sObservacao.equals(other.sObservacao)) {
			return false;
		}
		if (totalValue == null) {
			if (other.totalValue != null) {
				return false;
			}
		} else if (!totalValue.equals(other.totalValue)) {
			return false;
		}
		if (user == null) {
			if (other.user != null) {
				return false;
			}
		} else if (!user.equals(other.user)) {
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
		return "Order [id=" + id + ", changeValue=" + changeValue + ", closeDate=" + closeDate + ", discount="
				+ discount + ", idCustomer=" + idCustomer + ", idTable=" + idTable + ", openDate=" + openDate
				+ ", receivedValue=" + receivedValue + ", sObservacao=" + sObservacao + ", totalValue=" + totalValue
				+ ", orderStatus=" + orderStatus + ", productType=" + productType + ", product=" + product + ", user="
				+ user + "]";
	}

}