package com.straders.service.algobase.db.keys;

import java.io.Serializable;
import java.sql.Time;

public class TrailOrderKey implements Serializable {

	private static final long serialVersionUID = 1L;

	public String symbol;

	public Time time;
}
