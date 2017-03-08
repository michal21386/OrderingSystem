package pl.michal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.michal.dao.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
