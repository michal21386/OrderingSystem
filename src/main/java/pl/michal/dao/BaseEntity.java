package pl.michal.dao;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	public void cos(){
		
	}
	
	/**
	 * Final version of Base entity class
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String uuid = UUID.randomUUID().toString();
	
	@Override
	public int hashCode() {
		return this.uuid.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return this == obj || obj instanceof BaseEntity && Objects.equals(uuid, ((BaseEntity) obj).uuid);
	}

	public Long getId() {
		return id;
	}
}
