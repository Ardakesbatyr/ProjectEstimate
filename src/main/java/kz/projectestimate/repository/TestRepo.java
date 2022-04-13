package kz.projectestimate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kz.projectestimate.entity.TestEntityClass;

public interface TestRepo extends JpaRepository<TestEntityClass, Integer>{

}
