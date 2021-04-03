package com.straders.service.algobase.db.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.straders.service.algobase.db.keys.StockDataKey;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@Table(name = "stock_data", schema = "straders")
@IdClass(StockDataKey.class)
@EqualsAndHashCode
@ToString
public class StockDataModel {

	@Id
	@Column(name = "date")
	public Date date;

	@Id
	@Column(name = "time")
	private Time time;

	@Id
	@Column(name = "symbol")
	public String symbol;

	@Column(name = "price")
	private double price;

	@Column(name = "volume")
	private Double volume;

}
