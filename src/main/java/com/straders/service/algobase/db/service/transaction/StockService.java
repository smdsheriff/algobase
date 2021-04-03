package com.straders.service.algobase.db.service.transaction;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.straders.service.algobase.db.keys.StockDataKey;
import com.straders.service.algobase.db.model.StockDataModel;
import com.straders.service.algobase.db.repository.StockDataRepository;

@Service
public class StockService {

	@Autowired
	public StockDataRepository stock;

	public void save(StockDataModel model) {
		stock.save(model);
	}

	public List<StockDataModel> getLatestData(Date today) {
		List<StockDataModel> latestData = stock.getLatestData(today);
		return latestData.stream().limit(2).collect(Collectors.toList());
	}

	public void saveAll(List<StockDataModel> stockList) {
		stock.saveAll(stockList);
	}

	public Boolean existById(StockDataKey key) {
		return stock.existsById(key);
	}

	public void delete(StockDataKey historyKey) {
		stock.deleteById(historyKey);
	}

	public void deleteAll() {
		stock.deleteAll();
	}
}
