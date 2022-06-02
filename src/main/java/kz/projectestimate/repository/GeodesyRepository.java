package kz.projectestimate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kz.projectestimate.entity.Geodesy;


public interface GeodesyRepository extends JpaRepository<Geodesy, Integer>{
	
	@Query(value = "SELECT distinct *  FROM schema_estimate.Geodesy group by section", nativeQuery = true)
	List<Geodesy> findSection();
	
	@Query(value = "SELECT distinct *  FROM schema_estimate.Geodesy WHERE section=?1 group by subsection", nativeQuery = true)
	List<Geodesy> findSubSectionBySection(String section);
	
	@Query(value = "SELECT distinct *  FROM schema_estimate.Geodesy WHERE subsection=?1 group by chapter", nativeQuery = true)
	List<Geodesy> findChapterListBySubsection(String subsection);
	
	@Query(value = "SELECT distinct *  FROM schema_estimate.Geodesy WHERE chapter=?1 group by table_name", nativeQuery = true)
	List<Geodesy> findTableListByChapter(String chapter);
	
	@Query(value = "SELECT distinct *  FROM schema_estimate.Geodesy WHERE table_name=?1 group by position", nativeQuery = true)
	List<Geodesy> findPositionListByTable(String table_name);

//	@Query(value = "SELECT * FROM schema_estimate.Geodesy WHERE position LIKE '%1%'", nativeQuery = true)
//	public Geodesy findGeodesyByPosition(String position);
	
	@Query(value = "SELECT * FROM schema_estimate.Geodesy WHERE position=?1", nativeQuery = true)
	public Geodesy findGeodesyByPosition(String position);
	
	

}
