package pl.michal.dao;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * Fields:<br>
 * username - cannot be changed<br>
 * password - Bcrypt<br>
 * role - role in system (list)<br>
 * client - cannot be changed (added with account)<br>
 * <br>
 * 
 * @author Michal
 *
 */

@Entity
@Table(name = "uzytkownik", uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }) })
public class Account extends BaseEntity implements UserDetails {

	/**
	 * First version of account.
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	private String username;
	@NotNull
	private String password;
	@ManyToMany(fetch = FetchType.EAGER)
	// @formatter:off
	@JoinTable(name = "konto_rola", 
		joinColumns = @JoinColumn(name = "konto_id"), 
		inverseJoinColumns = @JoinColumn(name = "rola_id"))
//	@NotNull
	private Set<Roles> authorities;
	// @formatter:on

	@OneToOne
	@JoinColumn(name = "klient_id")
	// @NotNull
	private Client client;

	public Client getClient() {
		return client;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAuthorities(Set<Roles> authorities) {
		this.authorities = authorities;
	}

	@Override
	public Set<Roles> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
