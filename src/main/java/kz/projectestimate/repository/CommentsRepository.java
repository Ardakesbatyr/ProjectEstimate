package kz.projectestimate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kz.projectestimate.entity.Comments;


public interface CommentsRepository extends JpaRepository<Comments, Integer>  {

	@Query(value = "SELECT * FROM schema_estimate.comments WHERE element_name=?1", nativeQuery = true)
	public Comments findByName(String name);

}
