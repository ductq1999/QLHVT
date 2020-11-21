package qlhvt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import qlhvt.entities.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip, Integer> {

}
