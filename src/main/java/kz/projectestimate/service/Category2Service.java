package kz.projectestimate.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.projectestimate.entity.Category2;
import kz.projectestimate.entity.CategoryDto;
import kz.projectestimate.entity.CategoryPostDto;
import kz.projectestimate.repository.Category2Repository;

@Service
public class Category2Service {

	@Autowired
	private Category2Repository categoryRepository;

	@Autowired
	private ModelMapper modelMapper;

	public List<CategoryDto> getCategoryList() {

		List<Category2> categories = categoryRepository.findAll();

		List<CategoryDto> categoryDtos = new ArrayList<>();

		for (Category2 category : categories) {

			if (category.getParent() == null) {

				categoryDtos.add(convertToDto(category)); // System.out.println(category.getName());

				Set<Category2> children = category.getChildren();

				for (Category2 subCategory : children) {

					subCategory.setName("--" + subCategory.getName());

					categoryDtos.add(convertToDto(subCategory)); // System.out.println("--" + subCategory.getName());

					if (subCategory.getChildren() != null) {

						Set<Category2> children2 = subCategory.getChildren();

						for (Category2 subCategory2 : children2) {

							subCategory2.setName("--" + "--" + subCategory2.getName()); // System.out.println("--" +"--"
																						// + subCategory2.getName());

							categoryDtos.add(convertToDto(subCategory2));

							if (subCategory2.getChildren() != null) {

								Set<Category2> children3 = subCategory2.getChildren();

								for (Category2 subCategory3 : children3) {

									subCategory3.setName("--" + "--" + "--" + subCategory3.getName()); // System.out.println("--"+"--"+"--"
																										// +
																										// subCategory3.getName());

									categoryDtos.add(convertToDto(subCategory3));

									if (subCategory3.getChildren() != null) {

										Set<Category2> children4 = subCategory3.getChildren();

										for (Category2 subCategory4 : children4) {

											subCategory4.setName("--" + "--" + "--" + "--" + subCategory4.getName());

											categoryDtos.add(convertToDto(subCategory4));

										}
									}
								}
							}
						}
					}
				}
			}
		}

		return categoryDtos;

	}

	private CategoryDto convertToDto(Category2 category) {
		CategoryDto categoryDto = modelMapper.map(category, CategoryDto.class);
		return categoryDto;
	}

	public Category2 getCategoryById(Integer id) {
		return categoryRepository.findById(id).get();
	}

	public void saveOrUpdateCategory(Category2 category) {
		categoryRepository.save(category);
	}
	
	public void saveOrUpdateCategory(CategoryPostDto categoryPostDto) {
		Category2 category = new Category2();
		if (categoryPostDto.getParent2()!=null) {
		Integer id = categoryPostDto.getParent2();
		Category2 categoryParent = categoryRepository.findById(id).get();
		category.setParent(categoryParent);
		}
		category.setName(categoryPostDto.getName());
		
		categoryRepository.save(category);
	}

	public void deleteCategory(Integer id) {
		categoryRepository.deleteById(id);
	}

}
