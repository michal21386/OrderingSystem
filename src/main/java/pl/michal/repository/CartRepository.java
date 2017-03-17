package pl.michal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import pl.michal.dao.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{
	@Query("select c from Cart c where c.client.id=?#{principal.id}")
	public List<Cart> findAllByAuthenticatedClient();
	
	@Modifying
	@Query("delete from Cart c where c.id=?1 and c.client.id=?#{principal.id}")
	public void deleteFromCartByAuthenticatedUser(Long id);

	@Modifying
	@Query("delete from Cart c where c.client.id=?#{principal.id}")
	public void clearCartByAuthUser();
}
