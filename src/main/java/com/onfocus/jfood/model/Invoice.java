package com.onfocus.jfood.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the invoices database table.
 * 
 */
@Entity
@Table(name="invoices")
public class Invoice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(length=255)
	private String description;

    @Temporal( TemporalType.DATE)
	@Column(name="entry_date")
	private Date entryDate;

	@Column(name="invoice_value", precision=19, scale=2)
	private BigDecimal invoiceValue;

	//bi-directional many-to-one association to Supplier
    @ManyToOne
	@JoinColumn(name="id_supplier")
	private Supplier supplier;

    public Invoice() {
    }

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEntryDate() {
		return this.entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public BigDecimal getInvoiceValue() {
		return this.invoiceValue;
	}

	public void setInvoiceValue(BigDecimal invoiceValue) {
		this.invoiceValue = invoiceValue;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
}