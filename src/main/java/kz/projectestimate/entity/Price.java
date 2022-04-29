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
@Table(name = "price")
public class Price{
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "position", length = 1000, nullable=true)
	private String position;
	
	@Column(name = "unit", length = 255, nullable=true)
	private String unit;
	
	@Column(name = "value_xmin")
	private Double valueXmin;
	
	@Column(name = "value_xmax")
	private Double valueXmax;
		
	@Column(name = "value_a")
	private Double valueA;
	
	@Column(name = "value_b")
	private Double valueB;
	
	@Column(name = "value_k1")
	private Double valueK1;
	
	@Column(name = "value_k2")
	private Double valueK2;
	
	@Column(name = "section", length = 255, nullable=true)
	private String section;
	
	@Column(name = "subsection", length = 255, nullable=true)
	private String subsection;
	
	@Column(name = "chapter", length = 255, nullable=true)
	private String chapter;
	
	@Column(name = "table_name", length = 255, nullable=true)
	private String tableName;

	public Price(String section) {
		this.section = section;
	}
	
	

}
