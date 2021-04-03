package com.straders.service.algobase.db.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.straders.service.algobase.db.keys.RangeBoundKey;
import com.straders.service.algobase.db.model.RangeBoundModel;

@Repository
public interface RangeBoundRepository extends JpaRepository<RangeBoundModel, RangeBoundKey> {

	@Query("SELECT t from RangeBoundModel t WHERE t.date = :date")
	public List<RangeBoundModel> getTodayRange(@Param("date") Date date);
}
