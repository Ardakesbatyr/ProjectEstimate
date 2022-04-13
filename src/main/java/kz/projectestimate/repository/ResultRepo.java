package kz.projectestimate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kz.projectestimate.entity.Result;


public interface ResultRepo extends JpaRepository<Result, Integer>{

}
