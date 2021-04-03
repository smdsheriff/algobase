package com.straders.service.algobase.db.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.straders.service.algobase.db.keys.ExitOrderKey;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@Table(name = "exit_order", schema = "straders")
@IdClass(ExitOrderKey.class)
@EqualsAndHashCode
@ToString
public class ExitOrderModel {

	@Id
	@Column(name = "date")
	public Date date;

	@Id
	@Column(name = "symbol")
	public String symbol;

	@Column(name = "time")
	private Time time;

	@Column(name = "order_type")
	private String orderType;

	@Column(name = "exit_price")
	private Double exitPrice;

	@Column(name = "type")
	private String type;

	@Column(name = "strategy")
	private String strategy;

	public ExitOrderModel() {
		super();
	}
}
