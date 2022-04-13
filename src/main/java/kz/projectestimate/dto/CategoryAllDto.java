package kz.projectestimate.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import kz.projectestimate.entity.Category2;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryAllDto {
	
	@JsonProperty("id")
	private Integer id;

	@NotNull
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("alias")
    private String alias;
     
    @JsonProperty("parent")
    private Category2 parent;
     
    @JsonProperty("children")
    private Set<Category2> children = new HashSet<>();
}
