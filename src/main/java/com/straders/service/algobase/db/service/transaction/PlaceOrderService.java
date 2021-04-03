package com.straders.service.algobase.db.service.transaction;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.straders.service.algobase.db.keys.PlaceOrderKey;
import com.straders.service.algobase.db.model.PlaceOrderModel;
import com.straders.service.algobase.db.repository.PlaceOrderRepository;
import com.straders.service.algobase.messenger.Publisher;

@Service
public class PlaceOrderService {

	@Autowired
	public PlaceOrderRepository placeOrder;

	public boolean existsById(PlaceOrderKey keys) {
		return placeOrder.existsById(keys);
	}

	public void save(PlaceOrderModel model) {
		placeOrder.save(model);
		try {
			Publisher publish = new Publisher("placeOrder", "placeOrder", "placeOrder");
			publish.publish("placeOrder", model);
		} catch (Exception exception) {
			System.err.println("Exception while messgenger");
			exception.printStackTrace();
		}
	}

	public Optional<PlaceOrderModel> getOrder(PlaceOrderKey keys) {
		return placeOrder.findById(keys);
	}

	public PlaceOrderModel getOrderBySymbol(String symbol) {
		return placeOrder.getOrderBySymbol(symbol);
	}

	public List<PlaceOrderModel> getTodayOrder(Date today) {
		return placeOrder.getTodayOrder(today);
	}

	public void update(PlaceOrderModel orderModel) {
		placeOrder.save(orderModel);
	}

	public Integer checkOrderTime(Date date, Time time) {
		System.out.println("Actual Time " + time);
		return placeOrder.checkOrderTime(date, time).size();
	}

}
