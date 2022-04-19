package kz.projectestimate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.projectestimate.entity.Application2;
import kz.projectestimate.repository.Application2Repository;



@Service
public class Application2Service {

	@Autowired
	private Application2Repository application2Repository;
	
	public List<Application2> getApplication2List() {
		return application2Repository.findAll();
	}

	public Application2 getApplication2ById(Integer id) {
		return application2Repository.findById(id).get();
	}

	public void saveOrUpdateApplication2(Application2 application2) {

		application2Repository.save(application2);
	}
	
	public void deleteApplication2(Integer id) {
		application2Repository.deleteById(id);
	}
	


}
