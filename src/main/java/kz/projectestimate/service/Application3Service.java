package kz.projectestimate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.projectestimate.entity.Application3;

import kz.projectestimate.repository.Application3Repository;



@Service
public class Application3Service {

	@Autowired
	private Application3Repository application3Repository;
	
	public List<Application3> getApplication3List() {
		return application3Repository.findAll();
	}

	public Application3 getApplication3ById(String id) {
		return application3Repository.findById(id).get();
	}

	public void saveOrUpdateApplication3(Application3 application3) {

		application3Repository.save(application3);
	}
	
	public void deleteApplication3(String id) {
		application3Repository.deleteById(id);
	}
	


}
