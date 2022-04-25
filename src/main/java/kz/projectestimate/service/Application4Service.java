package kz.projectestimate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.projectestimate.entity.Application4;

import kz.projectestimate.repository.Application4Repository;



@Service
public class Application4Service {

	@Autowired
	private Application4Repository application4Repository;
	
	public List<Application4> getApplication4List() {
		return application4Repository.findAll();
	}

	public Application4 getApplication4ById(String id) {
		return application4Repository.findById(id).get();
	}

	public void saveOrUpdateApplication4(Application4 application4) {

		application4Repository.save(application4);
	}
	
	public void deleteApplication4(String id) {
		application4Repository.deleteById(id);
	}
	


}
