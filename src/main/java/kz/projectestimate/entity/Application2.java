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
@Table(name = "Application2")
public class Application2 {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name", length = 255, nullable=true)
	private String name;
	
	@Column(name = "ratio1", nullable=true)
	private Double ratio1;
	
	@Column(name = "ratio2", nullable=true)
	private Double ratio2;
}
