package com.kindsonthegenius.fleetapp.repositories;

import com.kindsonthegenius.fleetapp.models.Client;
import com.kindsonthegenius.fleetapp.models.VehicleMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleMovementRepository extends JpaRepository<VehicleMovement,Integer> {
}
