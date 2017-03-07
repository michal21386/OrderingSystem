package pl.michal.dao;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="produkty")
public class Products extends BaseEntity{
	
	private String name;
	private BigDecimal price;
	private int quantity;
	
}
