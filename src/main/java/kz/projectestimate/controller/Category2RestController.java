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

import kz.projectestimate.entity.Category2;
import kz.projectestimate.entity.CategoryDto;
import kz.projectestimate.entity.CategoryPostDto;
import kz.projectestimate.service.Category2Service;;

@RestController
@CrossOrigin(origins = "http://localhost:8080/category")
public class Category2RestController {

	@Autowired
	private Category2Service categoryService;

	@GetMapping("/categoryList")
	public ResponseEntity<List<CategoryDto>> getCategoryList() {
		List<CategoryDto> categoryDto = categoryService.getCategoryList();
		return new ResponseEntity<List<CategoryDto>>(categoryDto, HttpStatus.OK);
	}

	@GetMapping("/category/{id}")
	public ResponseEntity<Category2> getCategory(@PathVariable Integer id) {
		return new ResponseEntity<Category2>(categoryService.getCategoryById(id), HttpStatus.OK);
	}

	@PostMapping("/category/save")
	public ResponseEntity<Void> saveOrUpdateCategory(@RequestBody CategoryPostDto categoryPostDto) {
		categoryService.saveOrUpdateCategory(categoryPostDto);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@DeleteMapping("/category/delete/{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable Integer id) {
		categoryService.deleteCategory(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
