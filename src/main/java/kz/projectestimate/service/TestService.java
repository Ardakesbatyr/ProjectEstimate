package kz.projectestimate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.projectestimate.entity.TestEntityClass;
import kz.projectestimate.repository.TestRepo;

@Service
public class TestService {

	@Autowired
	private TestRepo testRepo;
	
	public List<TestEntityClass> getTestEntityClassList() {
		return testRepo.findAll();
	}

	public TestEntityClass getTestEntityClassById(Integer id) {
		return testRepo.findById(id).get();
	}

	public void saveOrUpdateTestEntityClass(TestEntityClass testEntityClass) {
		testEntityClass.setValueB(testEntityClass.getXmin()*testEntityClass.getXmax()*testEntityClass.getValueA());
		testRepo.save(testEntityClass);
	}
	
	public void deleteTestEntityClass(Integer id) {
		testRepo.deleteById(id);
	}
}
