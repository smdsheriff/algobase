package com.straders.service.algobase.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.straders.service.algobase.db.keys.TrailOrderKey;
import com.straders.service.algobase.db.model.TrailOrderModel;

@Repository
public interface TrailOrderRepository extends JpaRepository<TrailOrderModel, TrailOrderKey> {

}
