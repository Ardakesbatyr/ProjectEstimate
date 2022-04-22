package kz.projectestimate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kz.projectestimate.entity.Result;
import kz.projectestimate.repository.ResultRepository;


@Service
public class ResultService {

	@Autowired
	private ResultRepository resultRepository;
	
	public List<Result> getResultList() {
		return resultRepository.findAll();
	}

	public Result getResultById(Integer id) {
		return resultRepository.findById(id).get();
	}

	public void saveOrUpdateResult(Result result) {
		
		Result newResult=new Result();
		newResult.setCustomName(result.getCustomName());
		newResult.setNameOfPrice(result.getTableName()+" , "+result.getPosition());
		
		Integer valueX = result.getValueX();
		Integer valueXmax = result.getValueXmax();
		Integer valueXmin = result.getValueXmin();
		Integer valueA = result.getValueA();
		Integer valueB = result.getValueB();
		Double valueK = result.getValueK();
		Double valueP2 = result.getValueP2();
		Double valueP3 = result.getValueP3();
		Double valueP4 = result.getValueP4();
		
		if (valueXmin < valueX && valueX < valueXmax) {
			newResult.setCost((valueA+valueB*valueX)*valueP2*valueP3*valueP4*valueK);
		} else if (valueX < valueXmin) {
			newResult.setCost((valueA+valueB*(0.4*valueXmin+0.6*valueX))*valueP2*valueP3*valueP4*valueK);
		} else if (valueX > valueXmax) {
			newResult.setCost((valueA+valueB*(0.4*valueXmax+0.6*valueX))*valueP2*valueP3*valueP4*valueK);
		}
		
			newResult.setEstimateId(result.getEstimateId());
			newResult.setValueX(valueX);
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

}
