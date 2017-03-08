package pl.michal.dao;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "produkty")
public class Products extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "nazwa_produktu")
	private String name;
	@Column(name = "opis")
	private String description;
	@Column(name = "cena")
	private BigDecimal price;
	@Column(name = "ilosc_na_magazynie")
	private int quantity;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
