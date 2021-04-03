package com.straders.service.algobase.db.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.straders.service.algobase.db.keys.IndexDataKey;
import com.straders.service.algobase.db.model.IndexDataModel;

@Repository
public interface IndexDataRepository extends JpaRepository<IndexDataModel, IndexDataKey> {

	@Query("SELECT t from IndexDataModel t WHERE t.date = :date order by t.time DESC")
	public List<IndexDataModel> getLatestData(@Param("date") Date date);

}
