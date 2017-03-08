package pl.michal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.michal.dao.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	
	@Query("select a from Account a where a.id=?#{principal.id}")
	public Account findAuthorizedAccount();
	
	public Account findByUsername(String username);

}
