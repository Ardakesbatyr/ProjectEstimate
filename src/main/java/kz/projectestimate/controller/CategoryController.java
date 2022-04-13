package kz.projectestimate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kz.projectestimate.entity.Category;

import kz.projectestimate.service.CategoryService;

@RestController
@CrossOrigin(origins = "http://localhost:8080/category3")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/category3List")
	public ResponseEntity<List<Category>> getCategoryList() {
		return new ResponseEntity<List<Category>>(categoryService.getCategoryList(), HttpStatus.OK);
	}

	@GetMapping("/category3/{id}")
	public ResponseEntity<Category> getCategory(@PathVariable Integer id) {
		return new ResponseEntity<Category>(categoryService.getCategoryById(id), HttpStatus.OK);
	}

	@PostMapping("/category3/save")
	public ResponseEntity<Category> saveOrUpdateCategory(@RequestBody Category category) {
		categoryService.saveOrUpdateCategory(category);
		return new ResponseEntity<Category>(categoryService.getCategoryById(category.getId()),HttpStatus.OK);
	}

	@DeleteMapping("/category3/delete/{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable Integer id) {
		categoryService.deleteCategory(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
