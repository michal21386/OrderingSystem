package pl.michal.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "klient")
public class Client extends BaseEntity {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "imie")
	private String firstName;
	@Column(name = "nazwisko")
	private String lastName;
	@Column(name = "nazwa_firmy")
	private String companyName;
	private String nip;
	@Column(name = "numer_telefonu")
	private String phoneNo;
	private String email;
	@OneToOne(orphanRemoval = false)
	@JoinColumn(name = "konto_id")
	private Account account;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
