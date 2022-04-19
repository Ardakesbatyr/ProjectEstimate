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

import kz.projectestimate.entity.Application2;
import kz.projectestimate.service.Application2Service;


@RestController
@CrossOrigin(origins = "http://localhost:8080/new_estimate")
public class Application2Controller {

	@Autowired
	private Application2Service application2Service;

	@GetMapping("/application2List")
	public ResponseEntity<List<Application2>> getApplication2List() {
		return new ResponseEntity<List<Application2>>(application2Service.getApplication2List(), HttpStatus.OK);
	}

	@GetMapping("/application2/{id}")
	public ResponseEntity<Application2> getApplication2(@PathVariable Integer id) {
		return new ResponseEntity<Application2>(application2Service.getApplication2ById(id), HttpStatus.OK);
	}

	@PostMapping("/application2/save")
	public ResponseEntity<Void> saveOrUpdateResult(@RequestBody Application2 application2) {
		application2Service.saveOrUpdateApplication2(application2);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@DeleteMapping("/application2/delete/{id}")
	public ResponseEntity<Void> deleteApplication2(@PathVariable Integer id) {
		application2Service.deleteApplication2(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
