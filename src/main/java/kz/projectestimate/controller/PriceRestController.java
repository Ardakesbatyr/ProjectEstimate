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
	
	@GetMapping("/chapterList/{subsection}")
	public ResponseEntity<List<Price>> getChapterListBySubsection(@PathVariable("subsection") String subsection) {
		return new ResponseEntity<List<Price>>(priceService.getChapterListBySubsection(subsection), HttpStatus.OK);
	}
	
	@GetMapping("/tableList/{chapter}")
	public ResponseEntity<List<Price>> getTableListByChapter(@PathVariable("chapter") String chapter) {
		return new ResponseEntity<List<Price>>(priceService.getTableListByChapter(chapter), HttpStatus.OK);
	}
	
	@GetMapping("/positionList/{table_name}")
	public ResponseEntity<List<Price>> getPositionListByTable(@PathVariable("table_name") String table_name) {
		return new ResponseEntity<List<Price>>(priceService.getPositionListByTable(table_name), HttpStatus.OK);
	}
	
//	@GetMapping("/positionData/{position}")
//	public ResponseEntity<Price> getPriceByPosition(@PathVariable("position") String position) {
//		return new ResponseEntity<Price>(priceService.getPriceByPosition(position), HttpStatus.OK);
//	}
	
	@GetMapping("/positionData/{position}")
	public ResponseEntity<Price> getPriceByPosition(@PathVariable("position") String position) {
		Price price = priceService.getPriceByPosition("36.Узел учета нефти производительностью: от 0,5 до 5 тыс. м3/сут");
		Price price2 = priceService.getPriceById(48);
		System.out.println(price.getValueXmin());
		System.out.println(price2.getValueXmin());
		return new ResponseEntity<Price>(priceService.getPriceByPosition(position), HttpStatus.OK);
	}
	

}
