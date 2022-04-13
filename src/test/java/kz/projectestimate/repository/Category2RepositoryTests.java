package kz.projectestimate.repository;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import kz.projectestimate.entity.Category2;
import kz.projectestimate.main.ProjectEstimateApplication;

@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes=ProjectEstimateApplication.class)
public class Category2RepositoryTests {
	
	@Autowired
	private Category2Repository repo;
	
	@Test
	public void testCreateRootCategory() {
		Category2 category = new Category2("Раздел 2. Предприятия металлургии, горно-рудной и угольной промышленности");
		Category2 savedCategory = repo.save(category);
		
		assertThat(savedCategory.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testCreateSubCategory() {
		Category2 parent = new Category2(2);
		Category2 subCategory = new Category2("Подраздел 2. Нефтеперерабатывающая и нефтехимическая промышленность", parent);
		Category2 savedCategory = repo.save(subCategory);
		
		assertThat(savedCategory.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testCreateFewSubCategory() {
		Category2 parent = new Category2(7);
		Category2 subCategory1 = new Category2("Глава 1. Нефтедобывающая промышленность", parent);
		Category2 subCategory2 = new Category2("Глава 2. Магистральный транспорт нефти", parent);
		Category2 subCategory3 = new Category2("Глава 3. Предприятия по переработке нефтяного газа", parent);
		repo.saveAll(List.of(subCategory1,subCategory2,subCategory3));
	}
	
	@Test
	public void testCreateFew2SubCategory() {
		Category2 parent = new Category2(10);
		Category2 subCategory1 = new Category2("Таблица 1701-0101-01 - Нефтяные и газовые скважины", parent);
		Category2 subCategory2 = new Category2("Таблица 1701-0101-02 - Объекты сбора и транспорта нефти и нефтяного газа", parent);
		Category2 subCategory3 = new Category2("Таблица 1701-0101-03 - Объекты подготовки нефти, газа и воды", parent);
		Category2 subCategory4 = new Category2("Таблица 1701-0101-04 - Объекты поддержания пластового давления", parent);
		Category2 subCategory5 = new Category2("Таблица 1701-0101-05 - Объекты термических методов воздействия на пласт", parent);
		Category2 subCategory6 = new Category2("Таблица 1701-0101-06 - Производственные базы", parent);
		repo.saveAll(List.of(subCategory1,subCategory2,subCategory3,subCategory4,subCategory5,subCategory6));
	}
	
	@Test
	public void testGetCategory() {
		Category2 category = repo.findById(2).get();
		System.out.println(category.getName());
		
		Set<Category2> children = category.getChildren();
		
		for(Category2 subCategory : children) {
			System.out.println(subCategory.getName());
		}
		
		assertThat(children.size()).isGreaterThan(0);
	}
	
	@Test
	public void testPrintHierarchicalCategories() {
		Iterable<Category2> categories = repo.findAll();
		
		for(Category2 category : categories) {
			if(category.getParent()==null) {
				System.out.println(category.getName());
				
				Set<Category2> children = category.getChildren();
				for(Category2 subCategory : children) {
					System.out.println("--" + subCategory.getName());
								
					if (subCategory.getChildren()!=null) {
						Set<Category2> children2 = subCategory.getChildren();
						for(Category2 subCategory2 : children2) {
							System.out.println("--" +"--" + subCategory2.getName());
							if (subCategory2.getChildren()!=null) {
								Set<Category2> children3 = subCategory2.getChildren();
								for(Category2 subCategory3 : children3) {
									System.out.println("--"+"--"+"--" + subCategory3.getName());
									printChildren(subCategory3,1);
								}
							}
						}
					}
				}
			}
		}
	}
	
	private void printChildren(Category2 parent, int subLevel) {
		int newSubLevel=subLevel+1;
		Set<Category2> children = parent.getChildren();
		for(Category2 subCategory : children) {
			for(int i=0; i<newSubLevel;i++) {
				System.out.print("--");
			}
			System.out.println(subCategory.getName());
		}
	}
	
}
