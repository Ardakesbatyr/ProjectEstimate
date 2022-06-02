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

import kz.projectestimate.entity.Geodesy;
import kz.projectestimate.service.GeodesyService;

@RestController
@CrossOrigin(origins = "http://localhost:8080/geodesy")
public class GeodesyRestController {

	@Autowired
	private GeodesyService geodesyService;

	@GetMapping("/geodesyList")
	public ResponseEntity<List<Geodesy>> getGeodesyList() {
		return new ResponseEntity<List<Geodesy>>(geodesyService.getGeodesyList(), HttpStatus.OK);
	}

	@GetMapping("/geodesy/{id}")
	public ResponseEntity<Geodesy> getGeodesy(@PathVariable Integer id) {
		return new ResponseEntity<Geodesy>(geodesyService.getGeodesyById(id), HttpStatus.OK);
	}

	@PostMapping("/geodesy/save")
	public ResponseEntity<Void> saveOrUpdateGeodesy(@RequestBody Geodesy geodesy) {
		geodesyService.saveOrUpdateGeodesy(geodesy);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@DeleteMapping("/geodesy/delete/{id}")
	public ResponseEntity<Void> deleteGeodesy(@PathVariable Integer id) {
		geodesyService.deleteGeodesy(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping("/geodesy/sectionList")
	public ResponseEntity<List<Geodesy>> getSectionList() {
		return new ResponseEntity<List<Geodesy>>(geodesyService.getSectionList(), HttpStatus.OK);
	}
	
	@GetMapping("/geodesy/subsectionList/{section}")
	public ResponseEntity<List<Geodesy>> getSubSectionListBySection(@PathVariable("section") String section) {
		return new ResponseEntity<List<Geodesy>>(geodesyService.getSubSectionListBySection(section), HttpStatus.OK);
	}
	
	@GetMapping("/geodesy/chapterList/{subsection}")
	public ResponseEntity<List<Geodesy>> getChapterListBySubsection(@PathVariable("subsection") String subsection) {
		return new ResponseEntity<List<Geodesy>>(geodesyService.getChapterListBySubsection(subsection), HttpStatus.OK);
	}
	
	@GetMapping("/geodesy/tableList/{chapter}")
	public ResponseEntity<List<Geodesy>> getTableListByChapter(@PathVariable("chapter") String chapter) {
		return new ResponseEntity<List<Geodesy>>(geodesyService.getTableListByChapter(chapter), HttpStatus.OK);
	}
	
	@GetMapping("/geodesy/positionList/{table_name}")
	public ResponseEntity<List<Geodesy>> getPositionListByTable(@PathVariable("table_name") String table_name) {
		return new ResponseEntity<List<Geodesy>>(geodesyService.getPositionListByTable(table_name), HttpStatus.OK);
	}
	
	@GetMapping("/geodesy/positionData/{position}")
	public ResponseEntity<Geodesy> getGeodesyByPosition(@PathVariable("position") String position) {
		return new ResponseEntity<Geodesy>(geodesyService.getGeodesyByPosition(position), HttpStatus.OK);
	}

}
