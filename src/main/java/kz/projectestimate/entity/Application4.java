package kz.projectestimate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Application4")
public class Application4 {
	
	@Id
	@Column(name = "id", length = 64, nullable=true)
	private String id;
	
	@Column(name = "name", length = 500, nullable=true)
	private String name;
	
	@Column(name = "ratio", nullable=true)
	private Double ratio;

}
