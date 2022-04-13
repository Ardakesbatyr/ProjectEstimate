package kz.projectestimate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "testEntityClass")
public class TestEntityClass {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "xmin")
	private Integer xmin;
	
	@Column(name = "xmax")
	private Integer xmax;
	
	@Column(name = "valueA")
	private Integer valueA;
	
	@Column(name = "valueB")
	private Integer valueB;
	
	public TestEntityClass() {
	
	}

	public TestEntityClass(Integer id, String name, Integer xmin, Integer xmax, Integer valueA, Integer valueB) {
		super();
		this.id = id;
		this.name = name;
		this.xmin = xmin;
		this.xmax = xmax;
		this.valueA = valueA;
		this.valueB = valueB;
	}

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

	public Integer getXmin() {
		return xmin;
	}

	public void setXmin(Integer xmin) {
		this.xmin = xmin;
	}

	public Integer getXmax() {
		return xmax;
	}

	public void setXmax(Integer xmax) {
		this.xmax = xmax;
	}

	public Integer getValueA() {
		return valueA;
	}

	public void setValueA(Integer valueA) {
		this.valueA = valueA;
	}

	public Integer getValueB() {
		return valueB;
	}

	public void setValueB(Integer valueB) {
		this.valueB = valueB;
	}

}
