package pl.michal.dao;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name = "produkty")
public class Products extends BaseEntity {

	private static final long serialVersionUID = 1L;


	@Column(name = "nazwa_produktu")
	private String name;
	@Column(name = "opis")
	private String description;
	@Column(name = "cena")
	@Min(0)
	private BigDecimal price;
	@Column(name = "ilosc_na_magazynie")
	@Min(0)
	private int quantity;
	@ManyToOne
	@JoinColumn(name = "kategoria_id")
	private Category category;
	

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
