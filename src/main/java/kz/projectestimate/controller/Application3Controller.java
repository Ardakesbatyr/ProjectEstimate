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

import kz.projectestimate.entity.Application3;
import kz.projectestimate.service.Application3Service;


@RestController
@CrossOrigin(origins = "http://localhost:8080/new_estimate")
public class Application3Controller {

	@Autowired
	private Application3Service application3Service;

	@GetMapping("/application3List")
	public ResponseEntity<List<Application3>> getApplication3List() {
		return new ResponseEntity<List<Application3>>(application3Service.getApplication3List(), HttpStatus.OK);
	}

	@GetMapping("/application3/{id}")
	public ResponseEntity<Application3> getApplication3(@PathVariable String id) {
		return new ResponseEntity<Application3>(application3Service.getApplication3ById(id), HttpStatus.OK);
	}

	@PostMapping("/application3/save")
	public ResponseEntity<Void> saveOrUpdateResult(@RequestBody Application3 application3) {
		application3Service.saveOrUpdateApplication3(application3);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@DeleteMapping("/application3/delete/{id}")
	public ResponseEntity<Void> deleteApplication3(@PathVariable String id) {
		application3Service.deleteApplication3(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
