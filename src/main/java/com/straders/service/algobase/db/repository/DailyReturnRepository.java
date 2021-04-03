package com.straders.service.algobase.db.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.straders.service.algobase.db.model.DailyReturnModel;

@Repository
public interface DailyReturnRepository extends JpaRepository<DailyReturnModel, Date> {

	@Query("SELECT t from DailyReturnModel t WHERE t.date = :date")
	public List<DailyReturnModel> getTodayReturns(@Param("date") Date date);
}
