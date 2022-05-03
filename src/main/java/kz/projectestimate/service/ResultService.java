package kz.projectestimate.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.projectestimate.entity.Price;
import kz.projectestimate.entity.Result;
import kz.projectestimate.repository.ResultRepository;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime; 

@Service
public class ResultService {

	@Autowired
	private ResultRepository resultRepository;
	
	@Autowired
	private PriceService priceService;
	
	public List<Result> getResultList() {
		return resultRepository.findAll();
	}

	public Result getResultById(Integer id) {
		return resultRepository.findById(id).get();
	}

	public void saveOrUpdateResult(Result result) {
		
		Result newResult=new Result();
		Integer id = Integer.parseInt(result.getPosition());
		Price price = priceService.getPriceById(id);
		String position = price.getPosition();
		newResult.setCustomName(result.getCustomName());
		newResult.setNameOfPrice(result.getTableName()+" , "+ position);
		
		Double valueX = result.getValueX();
		newResult.setValueX(valueX);
		
		Double valueXmax = result.getValueXmax();
		newResult.setValueXmax(valueXmax);
		
		Double valueXmin = result.getValueXmin();
		newResult.setValueXmin(valueXmin);
		
		Double valueA = result.getValueA();
		newResult.setValueA(valueA);
		
		Double valueB = result.getValueB();
		newResult.setValueB(valueB);
		
		Double valueK = result.getValueK();
		newResult.setValueK(valueK);
		
		Double valueP2 = result.getValueP2();
		newResult.setValueP2(valueP2);
		
		Double valueP3 = result.getValueP3();
		newResult.setValueP3(valueP3);
		
		Double valueP4 = result.getValueP4();
		newResult.setValueP4(valueP4);
		
		if (valueXmin < valueX && valueX < valueXmax) {
			Double longDouble = (valueA+valueB*valueX)*valueP2*valueP3*valueP4*valueK;
			int temp = (int)(longDouble*100);
			double shortDouble = ((double)temp)/100;
			newResult.setCost(shortDouble);
		} else if (valueXmin == valueX || valueX == valueXmax) {
			Double longDouble = (valueA+valueB*valueX)*valueP2*valueP3*valueP4*valueK;
			int temp = (int)(longDouble*100);
			double shortDouble = ((double)temp)/100;
			newResult.setCost(shortDouble);
		} else if (valueX < valueXmin) {
			Double longDouble = (valueA+valueB*(0.4*valueXmin+0.6*valueX))*valueP2*valueP3*valueP4*valueK;
			int temp = (int)(longDouble*100);
			double shortDouble = ((double)temp)/100;
			newResult.setCost(shortDouble);
		} else if (valueX > valueXmax) {
			Double longDouble = (valueA+valueB*(0.4*valueXmax+0.6*valueX))*valueP2*valueP3*valueP4*valueK;
			int temp = (int)(longDouble*100);
			double shortDouble = ((double)temp)/100;
			newResult.setCost(shortDouble);
		}
		
			newResult.setEstimateId(result.getEstimateId());
			
			newResult.setEmail(result.getEmail());
			newResult.setCurrentTime(result.getCurrentTime());
			
			List<Result> listResult = getResultByEstimateId(result.getEstimateId());
			if (listResult.size()>0) {
			for (Result oneResult: listResult) {
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
		resultRepository.save(newResult);
	}
	
	public void deleteResult(Integer id) {
		resultRepository.deleteById(id);
	}

	public List<Result> getResultByEstimateId(Integer estimateId) {
		return resultRepository.findResultByEstimateId(estimateId);
	}

	public List<Result> getListOfEstimateId() {
		return resultRepository.findAllEstimateId();
	}

	public void editResult(Result result) {
		Result newResult=new Result();
		Integer id = result.getId();
		Result oldResult = resultRepository.findById(id).get();
		
		newResult.setId(id);
		newResult.setCustomName(result.getCustomName());
		newResult.setNameOfPrice(oldResult.getNameOfPrice());
	
		Double valueX = result.getValueX();
		newResult.setValueX(valueX);
		
		Double valueXmax = oldResult.getValueXmax();
		newResult.setValueXmax(valueXmax);
		
		Double valueXmin = oldResult.getValueXmin();
		newResult.setValueXmin(valueXmin);
		
		Double valueA = oldResult.getValueA();
		newResult.setValueA(valueA);
		
		Double valueB = oldResult.getValueB();
		newResult.setValueB(valueB);
		
		Double valueK = oldResult.getValueK();
		newResult.setValueK(valueK);
		
		Double valueP2 = oldResult.getValueP2();
		newResult.setValueP2(valueP2);
		
		Double valueP3 = oldResult.getValueP3();
		newResult.setValueP3(valueP3);
		
		Double valueP4 = oldResult.getValueP4();
		newResult.setValueP4(valueP4);
		
		if (valueXmin < valueX && valueX < valueXmax) {
			Double longDouble = (valueA+valueB*valueX)*valueP2*valueP3*valueP4*valueK;
			int temp = (int)(longDouble*100);
			double shortDouble = ((double)temp)/100;
			newResult.setCost(shortDouble);
		} else if (valueXmin == valueX || valueX == valueXmax) {
			Double longDouble = (valueA+valueB*valueX)*valueP2*valueP3*valueP4*valueK;
			int temp = (int)(longDouble*100);
			double shortDouble = ((double)temp)/100;
			newResult.setCost(shortDouble);
		} else if (valueX < valueXmin) {
			Double longDouble = (valueA+valueB*(0.4*valueXmin+0.6*valueX))*valueP2*valueP3*valueP4*valueK;
			int temp = (int)(longDouble*100);
			double shortDouble = ((double)temp)/100;
			newResult.setCost(shortDouble);
		} else if (valueX > valueXmax) {
			Double longDouble = (valueA+valueB*(0.4*valueXmax+0.6*valueX))*valueP2*valueP3*valueP4*valueK;
			int temp = (int)(longDouble*100);
			double shortDouble = ((double)temp)/100;
			newResult.setCost(shortDouble);
		}
		
			newResult.setEstimateId(oldResult.getEstimateId());
		
			newResult.setEmail(oldResult.getEmail());
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			String editedTime = dtf.format(now);
			newResult.setCurrentTime(editedTime);
			
			List<Result> listResult = getResultByEstimateId(result.getEstimateId());
			if (listResult.size()>0) {
			for (Result oneResult: listResult) {
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
		resultRepository.save(newResult);
	}

}
