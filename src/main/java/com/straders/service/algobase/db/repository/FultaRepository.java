package com.straders.service.algobase.db.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.straders.service.algobase.db.keys.FultaKey;
import com.straders.service.algobase.db.model.FultaModel;

@Repository
public interface FultaRepository extends JpaRepository<FultaModel, FultaKey> {

	@Query("SELECT t from FultaModel t WHERE t.date = :date")
	public List<FultaModel> getToday(@Param("date") Date date);

}
