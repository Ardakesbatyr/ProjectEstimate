package kz.projectestimate.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kz.projectestimate.entity.Price;
import kz.projectestimate.repository.PriceRepository;

@Service
public class PriceService {

	@Autowired
	private PriceRepository priceRepository;
	
	public List<Price> getPriceList() {
		return priceRepository.findAll();
	}

	public Price getPriceById(Integer id) {
		return priceRepository.findById(id).get();
	}

	public void saveOrUpdatePrice(Price price) {
		priceRepository.save(price);
	}
	
	public void deletePrice(Integer id) {
		priceRepository.deleteById(id);
	}

	public List<Price> getSectionList() {
		return priceRepository.findSection();
	}

	public List<Price> getSubSectionListBySection(String section) {
		return priceRepository.findSubSectionBySection(section);
	}

	public List<Price> getChapterListBySubsection(String subsection) {
		return priceRepository.findChapterListBySubsection(subsection);
	}

	public List<Price> getTableListByChapter(String chapter) {
		return priceRepository.findTableListByChapter(chapter);
	}

	public List<Price> getPositionListByTable(String table_name) {
		return priceRepository.findPositionListByTable(table_name);
	}

	public Price getPriceByPosition(String position) {
		return priceRepository.findPriceByPosition(position);
	}


}
