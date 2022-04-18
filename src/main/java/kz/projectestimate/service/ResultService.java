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
		resultRepository.save(result);
	}
	
	public void deleteResult(Integer id) {
		resultRepository.deleteById(id);
	}

}
