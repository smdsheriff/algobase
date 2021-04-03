package com.straders.service.algobase.db.service.transaction;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.straders.service.algobase.db.model.DailyCalculationModel;
import com.straders.service.algobase.db.repository.DailyCalculationRepository;

@Service
public class DailyService {

	@Autowired
	public DailyCalculationRepository daily;

	public List<DailyCalculationModel> getTodayCalc() {
		return daily.getTodayCalc(new Date(Instant.now().toEpochMilli()));
	}

	public List<DailyCalculationModel> findAll() {
		return daily.findAll();
	}
}
