package com.straders.service.algobase.db.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.straders.service.algobase.db.model.TrendModel;

@Repository
public interface TrendRepository extends JpaRepository<TrendModel, Date> {

	@Query("SELECT t from TrendModel t WHERE t.date = :date")
	public List<TrendModel> getTodayTrend(@Param("date") Date date);
}
