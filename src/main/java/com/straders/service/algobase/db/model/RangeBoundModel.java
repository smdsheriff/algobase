package com.straders.service.algobase.db.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.straders.service.algobase.db.keys.RangeBoundKey;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@Table(name = "range_bound", schema = "straders")
@IdClass(RangeBoundKey.class)
@EqualsAndHashCode
@ToString
public class RangeBoundModel {

	@Id
	@Column(name = "date")
	public Date date;

	@Id
	@Column(name = "symbol")
	public String symbol;

	@Column(name = "high")
	private Double high;

	@Column(name = "low")
	private Double low;

	@Column(name = "range")
	private Double range;

	@Column(name = "volume")
	private Integer volume;

	public RangeBoundModel() {
		super();
	}
}
