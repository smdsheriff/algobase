package com.straders.service.algobase.db.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.straders.service.algobase.db.keys.IndexDataKey;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@Table(name = "index_data", schema = "straders")
@IdClass(IndexDataKey.class)
@EqualsAndHashCode
@ToString
public class IndexDataModel {

	@Id
	@Column(name = "date")
	public Date date;

	@Id
	@Column(name = "time")
	private Time time;

	@Column(name = "index")
	public String index;

	@Column(name = "price")
	private double price;

}
