package kz.projectestimate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kz.projectestimate.entity.AutoCompleteDao;

@Service
public class AutoCompleteService {

	public List<String> doAutoComplete(final String input) {
		return AutoCompleteDao.getStrings(input);
	}

}
