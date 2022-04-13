package kz.projectestimate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "view")
public class View {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "custom_name")
	private String custom_name;
	
	@Column(name = "category_name")
	private String category_name;

	@Column(name = "argument")
	private Integer argument;
	
	@Column(name = "cost")
	private Integer cost;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustom_name() {
		return custom_name;
	}

	public void setCustom_name(String custom_name) {
		this.custom_name = custom_name;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public Integer getArgument() {
		return argument;
	}

	public void setArgument(Integer argument) {
		this.argument = argument;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public View(Integer id, String custom_name, String category_name, Integer argument, Integer cost) {
		super();
		this.id = id;
		this.custom_name = custom_name;
		this.category_name = category_name;
		this.argument = argument;
		this.cost = cost;
	}

	public View() {
		
	}
	
}
