package com.straders.service.algobase.db.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.straders.service.algobase.db.keys.ExitOrderKey;
import com.straders.service.algobase.db.model.ExitOrderModel;

@Repository
public interface ExitOrderRepository extends JpaRepository<ExitOrderModel, ExitOrderKey> {

	@Query("SELECT t from ExitOrderModel t WHERE t.symbol = :symbol")
	public ExitOrderModel getOrderBySymbol(@Param("symbol") String symbol);

	@Query("SELECT t from ExitOrderModel t WHERE t.date = :date")
	public List<ExitOrderModel> getTodayOrder(@Param("date") Date date);
}
