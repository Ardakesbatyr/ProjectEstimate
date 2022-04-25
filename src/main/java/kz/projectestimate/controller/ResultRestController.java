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


import kz.projectestimate.entity.Result;

import kz.projectestimate.service.ResultService;

@RestController
@CrossOrigin(origins = "http://localhost:8080/new_estimate")
public class ResultRestController {

	@Autowired
	private ResultService resultService;

	@GetMapping("/resultList")
	public ResponseEntity<List<Result>> getResultList() {
		return new ResponseEntity<List<Result>>(resultService.getResultList(), HttpStatus.OK);
	}

	@GetMapping("/result/id/{id}")
	public ResponseEntity<Result> getResult(@PathVariable Integer id) {
		return new ResponseEntity<Result>(resultService.getResultById(id), HttpStatus.OK);
	}

	@PostMapping("/result/save")
	public ResponseEntity<Void> saveOrUpdateResult(@RequestBody Result result) {
		resultService.saveOrUpdateResult(result);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/result/estimateId/{estimateId}")
	public ResponseEntity<List<Result>> getResultByEstimateId(@PathVariable Integer estimateId) {
		return new ResponseEntity<List<Result>>(resultService.getResultByEstimateId(estimateId), HttpStatus.OK);
	}

	@DeleteMapping("/result/delete/{id}")
	public ResponseEntity<Void> deleteResult(@PathVariable Integer id) {
		resultService.deleteResult(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/listOfEstimateId")
	public ResponseEntity<List<Result>> getListOfEstimateId() {
		return new ResponseEntity<List<Result>>(resultService.getListOfEstimateId(), HttpStatus.OK);
	}
	
	@PostMapping("/result/edit")
	public ResponseEntity<Void> editResult(@RequestBody Result result) {
		resultService.editResult(result);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
