package com.straders.service.algobase.db.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.straders.service.algobase.db.keys.TrendKey;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@Table(name = "trend", schema = "straders")
@IdClass(TrendKey.class)
@EqualsAndHashCode
@ToString
public class TrendModel {

	@Id
	@Column(name = "date")
	public Date date;

	@Column(name = "trend")
	public String trend;

	@Column(name = "high")
	public double high;

	@Column(name = "low")
	public double low;
}
