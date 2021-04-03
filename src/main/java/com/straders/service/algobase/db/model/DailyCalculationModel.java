package com.straders.service.algobase.db.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Immutable
@Data
@Table(name = "daily_calculation", schema = "straders")
@EqualsAndHashCode
@ToString
public class DailyCalculationModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "date")
	public Date date;

	@Column(name = "symbol")
	@Id
	public String symbol;

	@Column(name = "entry")
	private Double entry;

	@Column(name = "stoploss")
	private Double stoploss;

	@Column(name = "exit")
	private Double exit;

	@Column(name = "order_type")
	private String orderType;

	@Column(name = "target")
	private Double target;

	@Column(name = "entry_time")
	private Time entryTime;

	@Column(name = "exit_time")
	private Time exitTime;

	@Column(name = "process")
	private String process;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "points")
	private Integer points;

	@Column(name = "amount")
	private Double amount;

	@Column(name = "strategy")
	private String strategy;

}
