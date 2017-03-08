package pl.michal.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Category extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "nazwa")
	private String name;
	@OneToOne
	@JoinColumn(name = "kategoria_id")
	private Category parentCategory;
	
}
