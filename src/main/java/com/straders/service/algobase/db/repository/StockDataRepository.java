package com.straders.service.algobase.db.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.straders.service.algobase.db.keys.StockDataKey;
import com.straders.service.algobase.db.model.StockDataModel;

@Repository
public interface StockDataRepository extends JpaRepository<StockDataModel, StockDataKey> {

	@Query("SELECT t from StockDataModel t WHERE t.date = :date order by t.time DESC")
	public List<StockDataModel> getLatestData(@Param("date") Date date);

}
