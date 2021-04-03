package com.straders.service.algobase.db.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.straders.service.algobase.db.keys.TrailOrderKey;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@Table(name = "trail_order", schema = "straders")
@IdClass(TrailOrderKey.class)
@EqualsAndHashCode
@ToString
public class TrailOrderModel {

	@Id
	@Column(name = "symbol")
	public String symbol;

	@Id
	@Column(name = "time")
	public Time time;

	@Column(name = "date")
	public Date date;

	@Column(name = "previous_price")
	private Double previousPrice;

	@Column(name = "current_price")
	private Double currentPrice;

	@Column(name = "previous_target")
	private Double previousTarget;

	@Column(name = "current_target")
	private Double currentTarget;

	@Column(name = "previous_stoploss")
	private Double previousStoploss;

	@Column(name = "current_stoploss")
	private Double currentStoploss;

	@Column(name = "strategy")
	private String strategy;
	
	public TrailOrderModel() {
		super();
	}
}
