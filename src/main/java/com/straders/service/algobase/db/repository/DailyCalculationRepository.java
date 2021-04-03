package com.straders.service.algobase.db.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.straders.service.algobase.db.model.DailyCalculationModel;

@Repository
public interface DailyCalculationRepository extends JpaRepository<DailyCalculationModel, Date> {

	@Query("SELECT t from DailyCalculationModel t WHERE t.date = :date")
	public List<DailyCalculationModel> getTodayCalc(@Param("date") Date date);
}
