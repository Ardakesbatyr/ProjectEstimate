package kz.projectestimate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kz.projectestimate.entity.Company;

public interface CrudRepository extends JpaRepository<Company, Integer>{

}
