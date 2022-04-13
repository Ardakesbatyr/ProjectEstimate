package kz.projectestimate.entity;

import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;



@Entity
@Table(name = "category")
public class Category {
	@Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
     
    @Column(length = 128)
    private String name;
     
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id")
    private Category parent;
     
    //cascade = CascadeType.ALL
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private Set<Category> children = new HashSet<>();
     
    public Category(String name, Category parent) {
        this.name = name;
        this.parent = parent;
    }
     
    public Category(String name) {
        this.name = name;
    }  
 
    public Category() {
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
 
    public Category getParent() {
        return parent;
    }
 
    public void setParent(Category parent) {
        this.parent = parent;
    }
 
    public Set<Category> getChildren() {
        return children;
    }
 
    public void setChildren(Set<Category> children) {
        this.children = children;
    }
     
    public void addChild(Category children) {
        this.children.add(children);
    }
}