package kz.projectestimate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kz.projectestimate.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
