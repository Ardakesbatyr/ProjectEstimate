package kz.projectestimate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.projectestimate.entity.View;
import kz.projectestimate.repository.ViewRepository;

@Service
public class ViewService {

	@Autowired
	private ViewRepository viewRepository;

	public List<View> getViewList() {
		return viewRepository.findAll();
	}

	public View getViewById(Integer id) {
		return viewRepository.findById(id).get();
	}

	public void saveOrUpdateView(View view) {
		viewRepository.save(view);
	}

	public void deleteView(Integer id) {
		viewRepository.deleteById(id);
	}
	
}
