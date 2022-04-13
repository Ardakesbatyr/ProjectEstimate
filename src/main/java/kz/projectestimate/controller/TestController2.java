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
import kz.projectestimate.entity.TestEntityClass;
import kz.projectestimate.service.CategoryService;
import kz.projectestimate.service.TestService;

@RestController
@CrossOrigin(origins = "http://localhost:8080/test/*")
public class TestController2 {

	@Autowired
	private TestService testService;

	@GetMapping("/testList")
	public ResponseEntity<List<TestEntityClass>> getTestEntityClassList() {
		return new ResponseEntity<List<TestEntityClass>>(testService.getTestEntityClassList(), HttpStatus.OK);
	}

	@GetMapping("/test/{id}")
	public ResponseEntity<TestEntityClass> getTestEntityClass(@PathVariable Integer id) {
		return new ResponseEntity<TestEntityClass>(testService.getTestEntityClassById(id), HttpStatus.OK);
	}

	@PostMapping("/test/save")
	public ResponseEntity<TestEntityClass> saveOrUpdateTestEntityClass(@RequestBody TestEntityClass testEntityClass) {
		testService.saveOrUpdateTestEntityClass(testEntityClass);
		return new ResponseEntity<TestEntityClass>(testService.getTestEntityClassById(testEntityClass.getId()),HttpStatus.OK);
	}

	@DeleteMapping("/test/delete/{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable Integer id) {
		testService.deleteTestEntityClass(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
