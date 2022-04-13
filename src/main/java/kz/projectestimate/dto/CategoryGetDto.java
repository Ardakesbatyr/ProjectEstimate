package kz.projectestimate.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryGetDto {

	@JsonProperty("id")
	private Integer id;

	@NotNull
	@JsonProperty("name")
	private String name;

}
