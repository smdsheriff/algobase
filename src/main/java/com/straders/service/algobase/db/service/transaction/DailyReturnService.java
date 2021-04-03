package com.straders.service.algobase.db.service.transaction;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.straders.service.algobase.db.model.DailyReturnModel;
import com.straders.service.algobase.db.repository.DailyReturnRepository;

@Service
public class DailyReturnService {

	@Autowired
	public DailyReturnRepository daily;

	public List<DailyReturnModel> getTodayReturns() {
		return daily.getTodayReturns(new Date(Instant.now().toEpochMilli()));
	}

}
