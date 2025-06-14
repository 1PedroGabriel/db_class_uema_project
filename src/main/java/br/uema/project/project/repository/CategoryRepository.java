package br.uema.project.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.uema.project.project.entity.Category;

public interface CategoriesRepository extends JpaRepository<Category, Long> {
}
