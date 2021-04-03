package com.straders.service.algobase.db.repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.straders.service.algobase.db.keys.PlaceOrderKey;
import com.straders.service.algobase.db.model.PlaceOrderModel;

@Repository
public interface PlaceOrderRepository extends JpaRepository<PlaceOrderModel, PlaceOrderKey> {

	@Query("SELECT t from PlaceOrderModel t WHERE t.symbol = :symbol")
	public PlaceOrderModel getOrderBySymbol(@Param("symbol") String symbol);

	@Query("SELECT t from PlaceOrderModel t WHERE t.date = :date")
	public List<PlaceOrderModel> getTodayOrder(@Param("date") Date date);

	@Query(value = "SELECT place_order.symbol FROM straders.place_order WHERE place_order.date = :date"
			+ " and place_order.time >= cast(:time as TIME) - INTERVAL '1 minutes' and place_order.time <= cast(:time as TIME) + INTERVAL '1 minutes'",
			nativeQuery = true)
	public List<Object> checkOrderTime(@Param("date") Date date, @Param("time") Time time);
}
