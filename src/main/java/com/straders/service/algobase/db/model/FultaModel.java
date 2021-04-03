package com.straders.service.algobase.db.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.straders.service.algobase.db.keys.FultaKey;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@Table(name = "fulta", schema = "straders")
@IdClass(FultaKey.class)
@EqualsAndHashCode
@ToString
public class FultaModel {

	@Id
	@Column(name = "date")
	public Date date;

	@Id
	@Column(name = "symbol")
	public String symbol;

	@Column(name = "open")
	private Double open;

	@Column(name = "high")
	private Double high;

	@Column(name = "low")
	private Double low;

	@Column(name = "close")
	private Double close;

	@Column(name = "percentage")
	private Double percentage;

	@Column(name = "volume")
	private Integer volume;

	public FultaModel() {
		super();
	}
}
