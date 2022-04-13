package kz.projectestimate.entity;

public class CategoryDto{
	
	private Integer id;
     
    private String name;

 	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CategoryDto() {
	
	}

	public CategoryDto(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public CategoryDto(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CategoryDto [id=" + id + ", name=" + name + "]";
	}
   
	
}