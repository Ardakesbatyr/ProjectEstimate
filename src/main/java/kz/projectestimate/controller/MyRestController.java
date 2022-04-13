package kz.projectestimate.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import kz.projectestimate.entity.Result;
import kz.projectestimate.service.ResultService;

@RestController
//@CrossOrigin(origins = "http://localhost:8080/calculation")
public class MyRestController {
	
	@Autowired
	private ResultService resultService;
	
	@GetMapping("/calculation/{id}")
	public ResponseEntity<Result> getResult(@PathVariable Integer id) {
		return new ResponseEntity<Result>(resultService.getResultById(id), HttpStatus.OK);
	}

	
	@PostMapping("/calculation/save")
	public ResponseEntity<Result> saveOrUpdateResult(@RequestBody Result result) {
		resultService.saveOrUpdateResult(result);
		return new ResponseEntity<Result>(resultService.getResultById(result.getId()),HttpStatus.OK);
	}

}
