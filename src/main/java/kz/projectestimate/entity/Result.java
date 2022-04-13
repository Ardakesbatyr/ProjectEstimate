package kz.projectestimate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "result")
public class Result {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "valueX")
	private Integer valueX;
	
	@Column(name = "valueXmin")
	private Integer valueXmin;
	
	@Column(name = "valueXmax")
	private Integer valueXmax;
	
	@Column(name = "valueP2")
	private Double valueP2;
	
	@Column(name = "valueP3")
	private Double valueP3;
	
	@Column(name = "valueP4")
	private Double valueP4;
	
	@Column(name = "valueA")
	private Integer valueA;
	
	@Column(name = "valueB")
	private Integer valueB;
	
	@Column(name = "valueK1")
	private Double valueK1;
	
	@Column(name = "valueK2")
	private Double valueK2;
	
	@Column(name = "alias")
	private String alias;
	
	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Result() {
	
	}
	
	public Result(Integer id, String name, Integer valueX, Integer valueXmin, Integer valueXmax, Double valueP2,
			Double valueP3, Double valueP4, Integer valueA, Integer valueB, Double valueK1, Double valueK2) {
		super();
		this.id = id;
		this.name = name;
		this.valueX = valueX;
		this.valueXmin = valueXmin;
		this.valueXmax = valueXmax;
		this.valueP2 = valueP2;
		this.valueP3 = valueP3;
		this.valueP4 = valueP4;
		this.valueA = valueA;
		this.valueB = valueB;
		this.valueK1 = valueK1;
		this.valueK2 = valueK2;
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

	public Integer getValueX() {
		return valueX;
	}

	public void setValueX(Integer valueX) {
		this.valueX = valueX;
	}

	public Integer getValueXmin() {
		return valueXmin;
	}

	public void setValueXmin(Integer valueXmin) {
		this.valueXmin = valueXmin;
	}

	public Integer getValueXmax() {
		return valueXmax;
	}

	public void setValueXmax(Integer valueXmax) {
		this.valueXmax = valueXmax;
	}

	public Double getValueP2() {
		return valueP2;
	}

	public void setValueP2(Double valueP2) {
		this.valueP2 = valueP2;
	}

	public Double getValueP3() {
		return valueP3;
	}

	public void setValueP3(Double valueP3) {
		this.valueP3 = valueP3;
	}

	public Double getValueP4() {
		return valueP4;
	}

	public void setValueP4(Double valueP4) {
		this.valueP4 = valueP4;
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

	public Double getValueK1() {
		return valueK1;
	}

	public void setValueK1(Double valueK1) {
		this.valueK1 = valueK1;
	}

	public Double getValueK2() {
		return valueK2;
	}

	public void setValueK2(Double valueK2) {
		this.valueK2 = valueK2;
	}

	@Override
	public String toString() {
		return "Result [name=" + name + "]";
	}
	
	

	
}
