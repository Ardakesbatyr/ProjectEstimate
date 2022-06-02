package kz.projectestimate.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kz.projectestimate.entity.Geodesy;
import kz.projectestimate.repository.GeodesyRepository;

@Service
public class GeodesyService {

	@Autowired
	private GeodesyRepository geodesyRepository;
	
	public List<Geodesy> getGeodesyList() {
		return geodesyRepository.findAll();
	}

	public Geodesy getGeodesyById(Integer id) {
		return geodesyRepository.findById(id).get();
	}

	public void saveOrUpdateGeodesy(Geodesy Geodesy) {
		geodesyRepository.save(Geodesy);
	}
	
	public void deleteGeodesy(Integer id) {
		geodesyRepository.deleteById(id);
	}

	public List<Geodesy> getSectionList() {
		return geodesyRepository.findSection();
	}

	public List<Geodesy> getSubSectionListBySection(String section) {
		return geodesyRepository.findSubSectionBySection(section);
	}

	public List<Geodesy> getChapterListBySubsection(String subsection) {
		return geodesyRepository.findChapterListBySubsection(subsection);
	}

	public List<Geodesy> getTableListByChapter(String chapter) {
		return geodesyRepository.findTableListByChapter(chapter);
	}

	public List<Geodesy> getPositionListByTable(String table_name) {
		return geodesyRepository.findPositionListByTable(table_name);
	}

	public Geodesy getGeodesyByPosition(String position) {
		return geodesyRepository.findGeodesyByPosition(position);
	}


}
