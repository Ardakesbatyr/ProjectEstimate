package kz.projectestimate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kz.projectestimate.entity.Price;


public interface PriceRepository extends JpaRepository<Price, Integer>{
	
	@Query(value = "SELECT distinct *  FROM schema_estimate.price group by section", nativeQuery = true)
	List<Price> findSection();
	
	@Query(value = "SELECT distinct *  FROM schema_estimate.price WHERE section LIKE '%1%' group by subsection", nativeQuery = true)
	List<Price> findSubSectionBySection(String section);

}
