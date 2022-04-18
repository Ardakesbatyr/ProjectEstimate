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

import kz.projectestimate.entity.Price;
import kz.projectestimate.service.PriceService;

@RestController
@CrossOrigin(origins = "http://localhost:8080/new_estimate")
public class PriceRestController {

	@Autowired
	private PriceService priceService;

	@GetMapping("/priceList")
	public ResponseEntity<List<Price>> getPriceList() {
		return new ResponseEntity<List<Price>>(priceService.getPriceList(), HttpStatus.OK);
	}

	@GetMapping("/price/{id}")
	public ResponseEntity<Price> getPrice(@PathVariable Integer id) {
		return new ResponseEntity<Price>(priceService.getPriceById(id), HttpStatus.OK);
	}

	@PostMapping("/price/save")
	public ResponseEntity<Void> saveOrUpdatePrice(@RequestBody Price price) {
		priceService.saveOrUpdatePrice(price);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@DeleteMapping("/price/delete/{id}")
	public ResponseEntity<Void> deletePrice(@PathVariable Integer id) {
		priceService.deletePrice(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/sectionList")
	public ResponseEntity<List<Price>> getSectionList() {
		return new ResponseEntity<List<Price>>(priceService.getSectionList(), HttpStatus.OK);
	}
	
	@GetMapping("/subsectionList/{section}")
	public ResponseEntity<List<Price>> getSubSectionListBySection(@PathVariable("section") String section) {
		return new ResponseEntity<List<Price>>(priceService.getSubSectionListBySection(section), HttpStatus.OK);
	}

}
