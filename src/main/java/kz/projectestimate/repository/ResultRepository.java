package kz.projectestimate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kz.projectestimate.entity.Result;


public interface ResultRepository extends JpaRepository<Result, Integer>{

	@Query(value = "SELECT * FROM schema_estimate.result WHERE estimate_id=?1", nativeQuery = true)
	public List<Result> findResultByEstimateId(Integer estimateId);


}
