package com.kindsonthegenius.fleetapp.repositories;

import com.kindsonthegenius.fleetapp.models.Client;
import com.kindsonthegenius.fleetapp.models.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleTypeRepository extends JpaRepository<VehicleType,Integer> {
}
