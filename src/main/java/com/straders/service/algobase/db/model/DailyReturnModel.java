package com.straders.service.algobase.db.model;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name = "daily_return", schema = "straders")
@EqualsAndHashCode
@ToString
public class DailyReturnModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "date")
	public Date date;

	@Column(name = "amount")
	@Id
	private Double amount;

}
