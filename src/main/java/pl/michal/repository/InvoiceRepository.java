package pl.michal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.michal.dao.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long>{
	
	@Query("select i from Invoice i where i.id=i.last_insert_id()")
	public Invoice findLastInvoice();
}
