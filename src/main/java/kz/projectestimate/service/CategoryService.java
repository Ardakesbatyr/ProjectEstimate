package kz.projectestimate.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kz.projectestimate.entity.Category;
import kz.projectestimate.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> getCategoryList() {
		return categoryRepository.findAll();
	}

	public Category getCategoryById(Integer id) {
		return categoryRepository.findById(id).get();
	}

	public void saveOrUpdateCategory(Category category) {
		categoryRepository.save(category);
	}

	public void deleteCategory(Integer id) {
		categoryRepository.deleteById(id);
	}
}
