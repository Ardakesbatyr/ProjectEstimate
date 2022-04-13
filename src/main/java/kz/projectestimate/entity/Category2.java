package kz.projectestimate.entity;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "category2")
public class Category2 {

	@Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
     
    @Column(length = 128, nullable=false)
    private String name;
    
    @Column(length = 128)
    private String alias;
     
    @OneToOne
    @JoinColumn(name = "parent_id")
    private Category2 parent;
     
    @OneToMany(mappedBy = "parent")
    private Set<Category2> children = new HashSet<>();
    
	public Category2(Integer id) {
		this.id = id;
	}
	
	public Category2(String name) {
		this.name = name;
	}
	
//	public Category2(String name) {
//		this.name = name;
//		this.alias = name;
//	}
	
	public Category2(String name, Category2 parent) {
		this(name);
		this.parent = parent;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Category2 getParent() {
		return parent;
	}

	public void setParent(Category2 parent) {
		this.parent = parent;
	}

	public Set<Category2> getChildren() {
		return children;
	}

	public void setChildren(Set<Category2> children) {
		this.children = children;
	}

	public Category2(Integer id, String name, String alias, Category2 parent, Set<Category2> children) {
		super();
		this.id = id;
		this.name = name;
		this.alias = alias;
		this.parent = parent;
		this.children = children;
	}
	
	public Category2(Integer id, String name) {
	
		this.id = id;
		this.name = name;

	}


	public Category2() {
		
	}
     
    
}