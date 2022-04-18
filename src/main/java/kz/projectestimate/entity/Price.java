package kz.projectestimate.entity;

import java.io.Serializable;

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
public class Price implements Serializable{
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "position")
	private String position;
	
	@Column(name = "unit")
	private String unit;
	
	@Column(name = "value_xmin")
	private Integer valueXmin;
	
	@Column(name = "value_xmax")
	private Integer valueXmax;
		
	@Column(name = "value_a")
	private Integer valueA;
	
	@Column(name = "value_b")
	private Integer valueB;
	
	@Column(name = "value_k1")
	private Double valueK1;
	
	@Column(name = "value_k2")
	private Double valueK2;
	
	@Column(name = "section")
	private String section;
	
	@Column(name = "subsection")
	private String subsection;
	
	@Column(name = "chapter")
	private String chapter;
	
	@Column(name = "table_name")
	private String tableName;

	public Price(String section) {
		this.section = section;
	}
	
	

}
