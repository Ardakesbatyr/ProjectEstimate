package kz.projectestimate.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kz.projectestimate.entity.Geodesy;
import kz.projectestimate.entity.GeodesyResult;
import kz.projectestimate.entity.Result;


public interface GeodesyResultRepository extends JpaRepository<GeodesyResult, Integer>{

	@Query(value = "SELECT * FROM schema_estimate.geodesy_result WHERE estimate_id=?1", nativeQuery = true)
	public List<GeodesyResult> findGeodesyResultByEstimateId(Integer estimateId);
	
	@Query(value = "SELECT distinct *  FROM schema_estimate.geodesy_result group by estimate_id", nativeQuery = true)
	public List<GeodesyResult> findAllEstimateId();

}
