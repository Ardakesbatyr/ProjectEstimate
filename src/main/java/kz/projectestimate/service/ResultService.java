package kz.projectestimate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kz.projectestimate.entity.Result;

import kz.projectestimate.repository.ResultRepo;


@Service
public class ResultService {

	@Autowired
	private ResultRepo resultRepo;
	
	public List<Result> getResultList() {
		return resultRepo.findAll();
	}

	public Result getResultById(Integer id) {
		return resultRepo.findById(id).get();
	}

	public void saveOrUpdateResult(Result result) {
		resultRepo.save(result);
	}
	
	public void deleteResult(Integer id) {
		resultRepo.deleteById(id);
	}

}
