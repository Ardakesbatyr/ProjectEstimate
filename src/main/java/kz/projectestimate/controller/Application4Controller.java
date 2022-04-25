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

import kz.projectestimate.entity.Application4;
import kz.projectestimate.service.Application4Service;


@RestController
@CrossOrigin(origins = "http://localhost:8080/new_estimate")
public class Application4Controller {

	@Autowired
	private Application4Service application4Service;

	@GetMapping("/application4List")
	public ResponseEntity<List<Application4>> getApplication4List() {
		return new ResponseEntity<List<Application4>>(application4Service.getApplication4List(), HttpStatus.OK);
	}

	@GetMapping("/application4/{id}")
	public ResponseEntity<Application4> getApplication4(@PathVariable String id) {
		return new ResponseEntity<Application4>(application4Service.getApplication4ById(id), HttpStatus.OK);
	}

	@PostMapping("/application4/save")
	public ResponseEntity<Void> saveOrUpdateResult(@RequestBody Application4 application4) {
		application4Service.saveOrUpdateApplication4(application4);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@DeleteMapping("/application4/delete/{id}")
	public ResponseEntity<Void> deleteApplication4(@PathVariable String id) {
		application4Service.deleteApplication4(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
