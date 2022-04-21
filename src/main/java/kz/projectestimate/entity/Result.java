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
@Table(name = "result")
public class Result{
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "custom_name", length = 128, nullable=true)
	private String customName;
	
	@Column(name = "name_of_price", length = 128, nullable=true)
	private String nameOfPrice;
	
	@Column(name = "value_x", nullable=true)
	private Integer valueX;
	
	@Column(name = "value_xmax", nullable=true)
	private Integer valueXmax;
	
	@Column(name = "value_xmin", nullable=true)
	private Integer valueXmin;
	
	@Column(name = "value_a", nullable=true)
	private Integer valueA;
	
	@Column(name = "value_b", nullable=true)
	private Integer valueB;
	
	@Column(name = "cost", nullable=true)
	private Double cost;
	
	@Column(name = "value_p2", nullable=true)
	private Double valueP2;
	
	@Column(name = "value_p3", nullable=true)
	private Double valueP3;
	
	@Column(name = "value_p4", nullable=true)
	private Double valueP4;
	
	@Column(name = "value_k", nullable=true)
	private Double valueK;
	
	@Column(name = "section", length = 128, nullable=true)
	private String section;
	
	@Column(name = "subsection", length = 128, nullable=true)
	private String subsection;
	
	@Column(name = "chapter", length = 128, nullable=true)
	private String chapter;
	
	@Column(name = "table_name", length = 128, nullable=true)
	private String tableName;
	
	@Column(name = "position", length = 128, nullable=true)
	private String position;
	
	@Column(name = "total", nullable=true)
	private Double total;
	
	@Column(name = "estimate_id", nullable=true)
	private Integer estimateId;

}