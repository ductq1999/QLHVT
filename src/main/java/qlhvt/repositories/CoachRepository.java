package qlhvt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import qlhvt.entities.Coach;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Integer> {

}
