package kz.projectestimate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "result")
public class Result2 {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "valueX")
	private Integer valueX;
	
	@Column(name = "valueP2")
	private Double valueP2;
	
	@Column(name = "valueP3")
	private Double valueP3;
	
	@Column(name = "valueP4")
	private Double valueP4;
	
	@Column(name = "valueK1")
	private Double valueK1;
	
	@Column(name = "valueK2")
	private Double valueK2;
	
	@Column(name = "alias")
	private String alias;
}