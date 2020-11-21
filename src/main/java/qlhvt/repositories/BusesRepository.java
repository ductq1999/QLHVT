package qlhvt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import qlhvt.entities.Buses;

@Repository
public interface BusesRepository extends JpaRepository<Buses, Integer> {

}
