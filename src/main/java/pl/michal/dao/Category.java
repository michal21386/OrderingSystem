package pl.michal.dao;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "kategoria")
public class Category extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "nazwa")
	private String name;
	// @formatter:off
	@ManyToOne
	@JoinTable(name = "kategorie_drzewo", 
		joinColumns = @JoinColumn(name = "dziecko_id"), 
		inverseJoinColumns = @JoinColumn(name = "rodzic_id"))
	@JsonIgnoreProperties({"childrenCategory"})
	private Category parentCategory;
	@OneToMany
	@JoinTable(name = "kategorie_drzewo", 
		joinColumns = @JoinColumn(name = "rodzic_id"), 
		inverseJoinColumns = @JoinColumn(name = "dziecko_id"))
	@JsonIgnoreProperties({"parentCategory"})
	private Set<Category> childrenCategory;
	// @formatter:on
	@OneToMany(mappedBy = "category")
	private Set<Products> products;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

	public Set<Category> getChildrenCategory() {
		return childrenCategory;
	}

	public void setChildrenCategory(Set<Category> childCategory) {
		this.childrenCategory = childCategory;
	}

}
