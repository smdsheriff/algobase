package com.straders.service.algobase.db.service.transaction;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.straders.service.algobase.db.model.TrendModel;
import com.straders.service.algobase.db.repository.TrendRepository;

@Service
public class TrendService {

	@Autowired
	public TrendRepository trend;

	public List<TrendModel> getTodayTrend() {
		return trend.getTodayTrend(new Date(Instant.now().toEpochMilli()));
	}

	public List<TrendModel> findAll() {
		return trend.findAll();
	}

	public void save(TrendModel model) {
		trend.save(model);
	}
}
