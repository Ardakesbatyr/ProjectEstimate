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
@Table(name = "geodesy_result")
public class GeodesyResult{
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "email", length = 128, nullable=true)
	private String email;
	
	@Column(name = "currenttime", length = 128, nullable=true)
	private String currentTime;
	
	@Column(name = "custom_name", length = 255, nullable=true)
	private String customName;
	
	@Column(name = "name_of_price", length = 500, nullable=true)
	private String nameOfPrice;
	
	@Column(name = "value_x", nullable=true)
	private Double valueX;
	
	@Column(name = "cost", nullable=true)
	private Double cost;
	
	@Column(name = "value_k1", nullable=true)
	private Double valueK1;
	
	@Column(name = "value_k2", nullable=true)
	private Double valueK2;
	
	@Column(name = "value_k3", nullable=true)
	private Double valueK3;
	
	@Column(name = "value_k4", nullable=true)
	private Double valueK4;
	
	@Column(name = "geodesy_id", nullable=false)
	private Integer geodesyId;
	
	@Column(name = "total", nullable=true)
	private Double total;
	
	@Column(name = "estimate_id", nullable=true)
	private Integer estimateId;
	
	
}