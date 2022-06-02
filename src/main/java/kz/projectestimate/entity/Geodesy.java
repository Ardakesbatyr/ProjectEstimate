package kz.projectestimate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "geodesy")
public class Geodesy{
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "section", length = 255, nullable=true)
	private String section;
	
	@Column(name = "subsection", length = 255, nullable=true)
	private String subsection;
	
	@Column(name = "chapter", length = 255, nullable=true)
	private String chapter;
	
	@Column(name = "table_name", length = 255, nullable=true)
	private String tableName;
	
	@Column(name = "position", length = 1000, nullable=true)
	private String position;
	
	@Column(name = "unit", length = 255, nullable=true)
	private String unit;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "value_k1")
	private Double valueK1;
	
	@Column(name = "value_k2")
	private Double valueK2;
	
	@Column(name = "value_k3")
	private Double valueK3;
	
	@Column(name = "value_k4")
	private Double valueK4;
	
	public Geodesy(String section) {
		this.section = section;
	}

}
