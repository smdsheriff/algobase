package com.straders.service.algobase.db.service.transaction;

import java.sql.Date;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.straders.service.algobase.db.keys.RangeBoundKey;
import com.straders.service.algobase.db.model.RangeBoundModel;
import com.straders.service.algobase.db.repository.RangeBoundRepository;

@Service
public class RangeBoundService {

	@Autowired
	RangeBoundRepository rangeBound;

	public List<RangeBoundModel> findAll() {
		return rangeBound.findAll();
	}

	public void saveAll(List<RangeBoundModel> modelList) {
		rangeBound.saveAll(modelList);
	}

	public void save(RangeBoundModel model) {
		rangeBound.save(model);
	}

	public Optional<RangeBoundModel> findById(RangeBoundKey key) {
		return rangeBound.findById(key);
	}

	public void deleteAll() {
		rangeBound.deleteAll();
	}

	public List<RangeBoundModel> getTodayRange(Date today) {
		return rangeBound.getTodayRange(today);
	}

	public void deleteToday() {
		RangeBoundKey key = new RangeBoundKey();
		key.date = new Date(Instant.now().toEpochMilli());
		rangeBound.deleteById(key);
	}

}
