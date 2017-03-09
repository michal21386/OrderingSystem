package pl.michal.dao;

import javax.persistence.Entity;
import javax.persistence.Table;

/*
 * 
 * Tabela pomocnicza, dane zapisywane tymczasowo, koszyk i pozycje w nim znajduj¹ce widoczne po zalogowaniu,
 * pozostaj¹ tam do usuniêcia lub wys³ania zamówienia.
 * Dodajemy produkt do koszyka.
 * W koszyku zapisywana jest data dodania, id produktu, id klienta.
 * Wyszukiwanie wszystkich pozycji w koszyku po Id klienta.
 * Po z³o¿eniu zamówienia koszyk, przenoszony do tabeli zamówienia i czyszczony.
 * 
 */

/**
 * Fields:<br>
 * int quantity<br>
 * Products products<br>
 * Client client<br>
 * 
 * @author Michal Skwarczynski
 *
 */
@Entity
@Table(name = "koszyk")
public class Cart extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int quantity;
	private Products product;
	private Client client;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
