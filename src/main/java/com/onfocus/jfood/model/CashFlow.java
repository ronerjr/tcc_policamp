package com.onfocus.jfood.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the cash_flow database table.
 * 
 */
@Entity
@Table(name="cash_flow")
public class CashFlow implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long id;

    @Temporal( TemporalType.DATE)
	@Column(name="event_date", nullable=false)
	private Date eventDate;

	@Column(name="event_nature", length=50)
	private String eventNature;

	@Column(name="event_value", nullable=false, precision=7, scale=2)
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

}