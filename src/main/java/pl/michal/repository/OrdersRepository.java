package pl.michal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.michal.dao.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long>{

}
