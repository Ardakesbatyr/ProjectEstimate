package kz.projectestimate.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.projectestimate.entity.Geodesy;
import kz.projectestimate.entity.GeodesyResult;
import kz.projectestimate.entity.Price;
import kz.projectestimate.entity.Result;
import kz.projectestimate.repository.GeodesyResultRepository;
import kz.projectestimate.repository.ResultRepository;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime; 

@Service
public class GeodesyResultService {

	@Autowired
	private GeodesyResultRepository geodesyResultRepository;
	
	@Autowired
	private GeodesyService geodesyService;
	
	public List<GeodesyResult> getGeodesyResultList() {
		return geodesyResultRepository.findAll();
	}

	public GeodesyResult getGeodesyResultById(Integer id) {
		return geodesyResultRepository.findById(id).get();
	}

	public void saveOrUpdateGeodesyResult(GeodesyResult geodesyResult) {
		
		GeodesyResult newResult=new GeodesyResult();
		
		Integer geodesyId = geodesyResult.getGeodesyId();
		Geodesy geodesyById = geodesyService.getGeodesyById(geodesyId);
		String position = geodesyById.getPosition();
		Double price = geodesyById.getPrice();
		String tableName = geodesyById.getTableName();
		
		newResult.setGeodesyId(geodesyId);
		newResult.setCustomName(geodesyResult.getCustomName());
		newResult.setNameOfPrice(tableName+" , "+ position);
		
		Double valueX = geodesyResult.getValueX();
		newResult.setValueX(valueX);
		
		Double valueK1 = geodesyResult.getValueK1();
		newResult.setValueK1(valueK1);
		
		if (valueK1==null) {
			valueK1=1.0;
		}
		
		Double valueK2 = geodesyResult.getValueK2();
		newResult.setValueK2(valueK2);
		
		if (valueK2==null) {
			valueK2=1.0;
		}
		
		Double valueK3 = geodesyResult.getValueK3();
		newResult.setValueK3(valueK3);
		
		if (valueK3==null) {
			valueK3=1.0;
		}
		
		Double valueK4 = geodesyResult.getValueK4();
		newResult.setValueK4(valueK4);
		
		if (valueK4==null) {
			valueK4=1.0;
		}
		
		Double longDouble = valueX*price*valueK1*valueK2*valueK3*valueK4/1000;
		int temp = (int)(longDouble*100);
		double shortDouble = ((double)temp)/100;
		newResult.setCost(shortDouble);
		
		newResult.setEstimateId(geodesyResult.getEstimateId());
		newResult.setEmail(geodesyResult.getEmail());
		newResult.setCurrentTime(geodesyResult.getCurrentTime());
			
			List<GeodesyResult> listResult = getGeodesyResultByEstimateId(geodesyResult.getEstimateId());
			if (listResult.size()>0) {
			for (GeodesyResult oneResult: listResult) {
				Double subtotal = oneResult.getTotal();
				Double newCost = newResult.getCost();
				Double total =subtotal+newCost;
				newResult.setTotal(total);
				}
			}
			else {
				Double cost = newResult.getCost();
				newResult.setTotal(cost);
			}
			
			geodesyResultRepository.save(newResult);
	}
	
	public void deleteGeodesyResult(Integer id) {
		geodesyResultRepository.deleteById(id);
	}

	public List<GeodesyResult> getGeodesyResultByEstimateId(Integer estimateId) {
		return geodesyResultRepository.findGeodesyResultByEstimateId(estimateId);
	}

	public List<GeodesyResult> getListOfEstimateId() {
		return geodesyResultRepository.findAllEstimateId();
	}

	public void editResult(GeodesyResult geodesyResult) {
		
		GeodesyResult newResult=new GeodesyResult();
		
		Integer id = geodesyResult.getId();
		GeodesyResult oldResult = geodesyResultRepository.findById(id).get();
		
		Integer geodesyId = oldResult.getGeodesyId();
		Geodesy geodesyById = geodesyService.getGeodesyById(geodesyId);
		String position = geodesyById.getPosition();
		Double price = geodesyById.getPrice();
		String tableName = geodesyById.getTableName();
		
		newResult.setId(id);
		newResult.setCustomName(geodesyResult.getCustomName());
		newResult.setNameOfPrice(oldResult.getNameOfPrice());
		newResult.setGeodesyId(geodesyId);
		
		Double valueX = geodesyResult.getValueX();
		newResult.setValueX(valueX);
		
		Double valueK1 = oldResult.getValueK1();
		newResult.setValueK1(valueK1);
		
		if (valueK1==null) {
			valueK1=1.0;
		}
		
		Double valueK2 = oldResult.getValueK2();
		newResult.setValueK2(valueK2);
		
		if (valueK2==null) {
			valueK2=1.0;
		}
		
		Double valueK3 = oldResult.getValueK3();
		newResult.setValueK3(valueK3);
		
		if (valueK3==null) {
			valueK3=1.0;
		}
		
		Double valueK4 = oldResult.getValueK4();
		newResult.setValueK4(valueK4);
		
		if (valueK4==null) {
			valueK4=1.0;
		}
		
		Double longDouble = valueX*price*valueK1*valueK2*valueK3*valueK4/1000;
		int temp = (int)(longDouble*100);
		double shortDouble = ((double)temp)/100;
		newResult.setCost(shortDouble);
		
			newResult.setEstimateId(oldResult.getEstimateId());
		
			newResult.setEmail(oldResult.getEmail());
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			String editedTime = dtf.format(now);
			newResult.setCurrentTime(editedTime);
			
			List<GeodesyResult> listResult = getGeodesyResultByEstimateId(geodesyResult.getEstimateId());
			if (listResult.size()>0) {
			for (GeodesyResult oneResult: listResult) {
				Double subtotal = oneResult.getTotal();
				Double newCost = newResult.getCost();
				Double total =subtotal+newCost;
				newResult.setTotal(total);
				}
			}
			else {
				Double cost = newResult.getCost();
				newResult.setTotal(cost);
			}
			geodesyResultRepository.save(newResult);
	}

}
