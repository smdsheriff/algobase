package com.straders.service.algobase.db.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.straders.service.algobase.db.keys.HistoryDataKey;
import com.straders.service.algobase.db.model.HistoryDataModel;

@Repository
public interface HistoryDataRepository extends JpaRepository<HistoryDataModel, HistoryDataKey> {

	@Query("SELECT t from HistoryDataModel t WHERE t.date = :date and t.percentage=:percentage")
	List<HistoryDataModel> getByPercentage(@Param("date") Date date, @Param("percentage") Double percentage);

}
