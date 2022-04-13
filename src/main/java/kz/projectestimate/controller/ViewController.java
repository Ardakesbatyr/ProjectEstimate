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

import kz.projectestimate.entity.View;
import kz.projectestimate.service.ViewService;

@RestController
@CrossOrigin(origins = "http://localhost:8080/view")
public class ViewController {

	@Autowired
	private ViewService viewService;

	@GetMapping("/viewList")
	public ResponseEntity<List<View>> getViewList() {
		return new ResponseEntity<List<View>>(viewService.getViewList(), HttpStatus.OK);
	}

	@GetMapping("/view/{id}")
	public ResponseEntity<View> getCategory(@PathVariable Integer id) {
		return new ResponseEntity<View>(viewService.getViewById(id), HttpStatus.OK);
	}

	@PostMapping("/view/save")
	public ResponseEntity<View> saveOrUpdateView(@RequestBody View view) {
		viewService.saveOrUpdateView(view);
		return new ResponseEntity<View>(viewService.getViewById(view.getId()),HttpStatus.OK);
	}

	@DeleteMapping("/view/delete/{id}")
	public ResponseEntity<Void> deleteView(@PathVariable Integer id) {
		viewService.deleteView(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
