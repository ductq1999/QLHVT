package qlhvt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import qlhvt.entities.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer>{
	
}
