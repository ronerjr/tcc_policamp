package com.onfocus.jfood.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the cash_flow database table.
 * 
 */
@Entity
@Table(name = "cash_flow")
public class CashFlow implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name = "event_date")
	private Date eventDate;

	@Column(name = "event_nature")
	private String eventNature;

	@Column(name = "event_value")
	private BigDecimal eventValue;

	public CashFlow() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getEventDate() {
		return this.eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String getEventNature() {
		return this.eventNature;
	}

	public void setEventNature(String eventNature) {
		this.eventNature = eventNature;
	}

	public BigDecimal getEventValue() {
		return this.eventValue;
	}

	public void setEventValue(BigDecimal eventValue) {
		this.eventValue = eventValue;
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
				+ ((eventDate == null) ? 0 : eventDate.hashCode());
		result = prime * result
				+ ((eventNature == null) ? 0 : eventNature.hashCode());
		result = prime * result
				+ ((eventValue == null) ? 0 : eventValue.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		CashFlow other = (CashFlow) obj;
		if (eventDate == null) {
			if (other.eventDate != null) {
				return false;
			}
		} else if (!eventDate.equals(other.eventDate)) {
			return false;
		}
		if (eventNature == null) {
			if (other.eventNature != null) {
				return false;
			}
		} else if (!eventNature.equals(other.eventNature)) {
			return false;
		}
		if (eventValue == null) {
			if (other.eventValue != null) {
				return false;
			}
		} else if (!eventValue.equals(other.eventValue)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
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
		return "CashFlow [id=" + id + ", eventDate=" + eventDate
				+ ", eventNature=" + eventNature + ", eventValue=" + eventValue
				+ "]";
	}

}