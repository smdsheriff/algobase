package com.straders.service.algobase.db.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.straders.service.algobase.db.keys.PlaceOrderKey;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@Table(name = "place_order", schema = "straders")
@IdClass(PlaceOrderKey.class)
@EqualsAndHashCode
@ToString
public class PlaceOrderModel {

	@Id
	@Column(name = "date")
	public Date date;

	@Id
	@Column(name = "symbol")
	public String symbol;

	@Column(name = "time")
	private Time time;

	@Column(name = "strategy")
	private String strategy;

	@Column(name = "order_type")
	private String orderType;

	@Column(name = "strike_price")
	private Double strikePrice;

	@Column(name = "target_price")
	private Double targetPrice;

	@Column(name = "stoploss_price")
	private Double stoplossPrice;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "trail")
	private Boolean trail;

	public PlaceOrderModel() {
		super();
	}
}
