package com.straders.service.algobase.db.service.transaction;

import java.sql.Date;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.straders.service.algobase.db.keys.FultaKey;
import com.straders.service.algobase.db.model.FultaModel;
import com.straders.service.algobase.db.repository.FultaRepository;

@Service
public class FultaService {

	@Autowired
	FultaRepository fulta;

	public List<FultaModel> findAll() {
		return fulta.findAll();
	}

	public void saveAll(List<FultaModel> modelList) {
		fulta.saveAll(modelList);
	}

	public void save(FultaModel model) {
		fulta.save(model);
	}

	public Optional<FultaModel> findById(FultaKey key) {
		return fulta.findById(key);
	}

	public void deleteAll() {
		fulta.deleteAll();
	}

	public void deleteToday() {
		FultaKey key = new FultaKey();
		key.date = new Date(Instant.now().toEpochMilli());
		fulta.deleteById(key);
	}

	public List<FultaModel> getToday(Date date) {
		return fulta.getToday(date);
	}
}
