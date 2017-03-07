package pl.michal.dao;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "role")
public class Roles extends BaseEntity implements GrantedAuthority {
	
	/**
	 * Final version of roles
	 */
	private static final long serialVersionUID = 1L;
	
	private String role;
	
	@Override
	public String getAuthority() {
		return "ROLE_"+this.role;
	}
}
