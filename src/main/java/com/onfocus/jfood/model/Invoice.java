package com.onfocus.jfood.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the invoice database table.
 * 
 */
@Entity
@Table(name = "invoices")
public class Invoice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "description")
	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name = "entry_date")
	private Date entryDate;

	@Column(name = "invoice_value")
	private BigDecimal invoiceValue;

	// bi-directional many-to-one association to Supplier
	@ManyToOne
	@JoinColumn(name = "id_supplier")
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((entryDate == null) ? 0 : entryDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((invoiceValue == null) ? 0 : invoiceValue.hashCode());
		result = prime * result
				+ ((supplier == null) ? 0 : supplier.hashCode());
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
		Invoice other = (Invoice) obj;
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (entryDate == null) {
			if (other.entryDate != null) {
				return false;
			}
		} else if (!entryDate.equals(other.entryDate)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (invoiceValue == null) {
			if (other.invoiceValue != null) {
				return false;
			}
		} else if (!invoiceValue.equals(other.invoiceValue)) {
			return false;
		}
		if (supplier == null) {
			if (other.supplier != null) {
				return false;
			}
		} else if (!supplier.equals(other.supplier)) {
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
		return "Invoice [id=" + id + ", description=" + description
				+ ", entryDate=" + entryDate + ", invoiceValue=" + invoiceValue
				+ ", supplier=" + supplier + "]";
	}

}