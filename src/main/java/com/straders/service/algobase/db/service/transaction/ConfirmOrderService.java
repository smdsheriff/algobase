package com.straders.service.algobase.db.service.transaction;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.straders.service.algobase.db.keys.ConfirmOrderKey;
import com.straders.service.algobase.db.model.ConfirmOrderModel;
import com.straders.service.algobase.db.repository.ConfirmOrderRepository;

@Service
public class ConfirmOrderService {

	@Autowired
	public ConfirmOrderRepository confirmOrder;

	public void save(ConfirmOrderModel model) {
		confirmOrder.save(model);
	}

	public void saveAll(List<ConfirmOrderModel> confirmList) {
		confirmOrder.saveAll(confirmList);
	}

	public Boolean existById(ConfirmOrderKey key) {
		return confirmOrder.existsById(key);
	}

	public void delete(ConfirmOrderKey confirmKey) {
		if (existById(confirmKey)) {
			confirmOrder.deleteById(confirmKey);
		}
	}

	public void deleteAll() {
		confirmOrder.deleteAll();
	}

	public void deleteToday() {
		ConfirmOrderKey key = new ConfirmOrderKey();
		key.date = new Date(Instant.now().toEpochMilli());
		confirmOrder.deleteById(key);
	}
}
