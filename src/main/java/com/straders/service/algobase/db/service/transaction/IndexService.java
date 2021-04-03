package com.straders.service.algobase.db.service.transaction;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.straders.service.algobase.db.model.IndexDataModel;
import com.straders.service.algobase.db.repository.IndexDataRepository;

@Service
public class IndexService {

	@Autowired
	public IndexDataRepository index;

	public void save(IndexDataModel model) {
		index.save(model);
	}

	public List<IndexDataModel> getLatestData(Date today) {
		List<IndexDataModel> latestData = index.getLatestData(today);
		return latestData.stream().limit(2).collect(Collectors.toList());
	}
}
