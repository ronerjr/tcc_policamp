package com.onfocus.jfood.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the orders database table.
 * 
 */
@Entity
@Table(name="orders")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="change_value", precision=7, scale=2)
	private BigDecimal changeValue;

    @Temporal( TemporalType.DATE)
	@Column(name="close_date")
	private Date closeDate;

	@Column(precision=3)
	private BigDecimal discount;

	@Column(name="id_customer")
	private Long idCustomer;

	@Column(name="id_table")
	private Long idTable;

    @Temporal( TemporalType.DATE)
	@Column(name="open_date", nullable=false)
	private Date openDate;

	@Column(name="received_value", precision=7, scale=2)
	private BigDecimal receivedValue;

	@Column(name="s_observacao", length=255)
	private String sObservacao;

	@Column(name="total_value", nullable=false, precision=7, scale=2)
	private BigDecimal totalValue;

	//bi-directional many-to-one association to OrderStatus
    @ManyToOne
	@JoinColumn(name="id_status", nullable=false)
	private OrderStatus orderStatus;

	//bi-directional many-to-one association to ProductType
    @ManyToOne
	@JoinColumn(name="id_payment_mode")
	private ProductType productType;

	//bi-directional many-to-one association to Product
    @ManyToOne
	@JoinColumn(name="id_product", nullable=false)
	private Product product;

	//bi-directional many-to-one association to User
    @ManyToOne
	@JoinColumn(name="id_user", nullable=false)
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
	
}