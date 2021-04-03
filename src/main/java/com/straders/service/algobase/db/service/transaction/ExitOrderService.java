package com.straders.service.algobase.db.service.transaction;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.straders.service.algobase.db.keys.ExitOrderKey;
import com.straders.service.algobase.db.model.ExitOrderModel;
import com.straders.service.algobase.db.repository.ExitOrderRepository;
import com.straders.service.algobase.messenger.Publisher;

@Service
public class ExitOrderService {

	@Autowired
	public ExitOrderRepository exitOrder;

	public void save(ExitOrderModel model) {
		exitOrder.save(model);
	}

	public ExitOrderModel getOrderBySymbol(String symbol) {
		return exitOrder.getOrderBySymbol(symbol);
	}

	public void saveAll(List<ExitOrderModel> exitList) {
		exitOrder.saveAll(exitList);
		try {
			exitList.stream().forEach(exit -> {
				Publisher publish = new Publisher("exitOrder", "exitOrder", "exitOrder");
				publish.publish("exitOrder", exit);
			});
		} catch (Exception exception) {
			System.err.println("Exception for exit messenger");
			exception.printStackTrace();
		}
	}

	public boolean existsById(ExitOrderKey keys) {
		return exitOrder.existsById(keys);
	}

	public List<ExitOrderModel> getTodayOrder(Date today) {
		return exitOrder.getTodayOrder(today);
	}
	
	public Optional<ExitOrderModel> getExitOrder(ExitOrderKey exitKey){
		return exitOrder.findById(exitKey);
	}
}
