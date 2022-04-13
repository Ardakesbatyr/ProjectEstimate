package kz.projectestimate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.projectestimate.entity.Company;
import kz.projectestimate.repository.CrudRepository;

@Service
public class CrudService {

	@Autowired
	private CrudRepository crudRepository;

	public List<Company> getCompanyList() {
		return crudRepository.findAll();
	}

	public Company getCompanyById(Integer id) {
		return crudRepository.findById(id).get();
	}

	public void saveOrUpdateCompany(Company company) {
		crudRepository.save(company);
	}
	
	public void deleteCompany(Integer id) {
		crudRepository.deleteById(id);
	}

}
