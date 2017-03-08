package pl.michal.service;

import java.util.List;

import pl.michal.dao.Account;
/**
 * CRUD Service:
 * Add - only Admin <br>
 * Delete <br>
 * Get <br>
 * GetAll <br>
 * Update <br>
 *  
 * @author Michal
 *
 */
public interface AccountService {
	
	public Account Get();
	public void Delete(String password); 
	public void Update(String oldPassword, String newPassword);
	
}
