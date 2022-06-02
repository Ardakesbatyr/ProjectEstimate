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

import kz.projectestimate.entity.GeodesyResult;
import kz.projectestimate.entity.Result;
import kz.projectestimate.service.GeodesyResultService;
import kz.projectestimate.service.ResultService;

@RestController
@CrossOrigin(origins = "http://localhost:8080/new_estimate")
public class GeodesyResultRestController {

	@Autowired
	private GeodesyResultService geodesyResultService;

	@GetMapping("/geodesyResultList")
	public ResponseEntity<List<GeodesyResult>> getResultList() {
		return new ResponseEntity<List<GeodesyResult>>(geodesyResultService.getGeodesyResultList(), HttpStatus.OK);
	}

	@GetMapping("/geodesyResult/id/{id}")
	public ResponseEntity<GeodesyResult> getResult(@PathVariable Integer id) {
		return new ResponseEntity<GeodesyResult>(geodesyResultService.getGeodesyResultById(id), HttpStatus.OK);
	}

	@PostMapping("/geodesyResult/save")
	public ResponseEntity<Void> saveOrUpdateResult(@RequestBody GeodesyResult geodesyResult) {
		geodesyResultService.saveOrUpdateGeodesyResult(geodesyResult);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/geodesyResult/estimateId/{estimateId}")
	public ResponseEntity<List<GeodesyResult>> getGeodesyResultByEstimateId(@PathVariable Integer estimateId) {
		return new ResponseEntity<List<GeodesyResult>>(geodesyResultService.getGeodesyResultByEstimateId(estimateId), HttpStatus.OK);
	}

	@DeleteMapping("/geodesyResult/delete/{id}")
	public ResponseEntity<Void> deleteGeodesyResult(@PathVariable Integer id) {
		geodesyResultService.deleteGeodesyResult(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/geodesyResult/listOfEstimateId")
	public ResponseEntity<List<GeodesyResult>> getListOfEstimateId() {
		return new ResponseEntity<List<GeodesyResult>>(geodesyResultService.getListOfEstimateId(), HttpStatus.OK);
	}
	
	@PostMapping("/geodesyResult/edit")
	public ResponseEntity<Void> editResult(@RequestBody GeodesyResult geodesyResult) {
		geodesyResultService.editResult(geodesyResult);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
