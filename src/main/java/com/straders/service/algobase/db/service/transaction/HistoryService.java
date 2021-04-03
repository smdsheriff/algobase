package com.straders.service.algobase.db.service.transaction;

import java.sql.Date;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.straders.service.algobase.db.keys.HistoryDataKey;
import com.straders.service.algobase.db.model.HistoryDataModel;
import com.straders.service.algobase.db.repository.HistoryDataRepository;

@Service
public class HistoryService {

	@Autowired
	public HistoryDataRepository history;

	public void save(HistoryDataModel model) {
		history.save(model);
	}

	public void saveAll(List<HistoryDataModel> confirmList) {
		history.saveAll(confirmList);
	}

	public Boolean existById(HistoryDataKey key) {
		return history.existsById(key);
	}

	public void delete(HistoryDataKey historyKey) {
		history.deleteById(historyKey);
	}

	public void deleteAll() {
		history.deleteAll();
	}

	public Optional<HistoryDataModel> getPreviousData(String symbol) {
		HistoryDataKey key = new HistoryDataKey();
		LocalDate loaclDate = LocalDate.now();
		if (DayOfWeek.from(loaclDate).name().equalsIgnoreCase(DayOfWeek.MONDAY.name())) {
			key.date = new Date(Instant.now().minus(3, ChronoUnit.DAYS).toEpochMilli());
		} else {
			key.date = new Date(Instant.now().minus(1, ChronoUnit.DAYS).toEpochMilli());
		}
		key.symbol = symbol;
		return history.findById(key);
	}

	public List<HistoryDataModel> getByPercentage(Double percentage) {
		return history.getByPercentage(new Date(Instant.now().minus(1, ChronoUnit.DAYS).toEpochMilli()), percentage);
	}
}
