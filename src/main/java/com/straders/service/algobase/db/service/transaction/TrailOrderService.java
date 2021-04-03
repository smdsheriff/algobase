package com.straders.service.algobase.db.service.transaction;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.straders.service.algobase.db.keys.TrailOrderKey;
import com.straders.service.algobase.db.model.TrailOrderModel;
import com.straders.service.algobase.db.repository.TrailOrderRepository;
import com.straders.service.algobase.messenger.Publisher;

@Service
public class TrailOrderService {

	@Autowired
	public TrailOrderRepository trailOrder;

	public boolean existsById(TrailOrderKey keys) {
		return trailOrder.existsById(keys);
	}

	public void save(TrailOrderModel model) {
		trailOrder.save(model);
		try {
			Publisher publish = new Publisher("trailOrder", "trailOrder", "trailOrder");
			publish.publish("trailOrder", model);
		} catch (Exception exception) {
			System.err.println("Exception while messgenger");
			exception.printStackTrace();
		}
	}

	public Optional<TrailOrderModel> getOrder(TrailOrderKey keys) {
		return trailOrder.findById(keys);
	}

}
