package qlhvt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import qlhvt.entities.DriverTrip;

@Repository
public interface DriverTripRepository extends JpaRepository<DriverTrip, Integer> {

}
