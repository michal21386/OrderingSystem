package pl.michal.dao;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="koszyk")
public class Cart extends BaseEntity{

	private int quantity;
	private Date addDate;
	private Products produkt;
}
