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
	
	@Query(value = "SELECT distinct *  FROM schema_estimate.price WHERE subsection LIKE '%1%' group by chapter", nativeQuery = true)
	List<Price> findChapterListBySubsection(String subsection);
	
	@Query(value = "SELECT distinct *  FROM schema_estimate.price WHERE chapter LIKE '%1%' group by table_name", nativeQuery = true)
	List<Price> findTableListByChapter(String chapter);
	
	@Query(value = "SELECT distinct *  FROM schema_estimate.price WHERE table_name LIKE '%1%' group by position", nativeQuery = true)
	List<Price> findPositionListByTable(String table_name);

//	@Query(value = "SELECT * FROM schema_estimate.price WHERE position LIKE '%1%'", nativeQuery = true)
//	public Price findPriceByPosition(String position);
	
	public Price findPriceByPosition(String position);
	
	

}
