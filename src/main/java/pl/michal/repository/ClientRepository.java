package pl.michal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.michal.dao.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

	@Query("select c from Client c where c.account.id=?#{principal.id}")
	Client findAuthorizedClient();

}
