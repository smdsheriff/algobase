package com.straders.service.algobase.db.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.straders.service.algobase.db.keys.ConfirmOrderKey;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@Table(name = "confirm_order", schema = "straders")
@IdClass(ConfirmOrderKey.class)
@EqualsAndHashCode
@ToString
public class ConfirmOrderModel {

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

}
