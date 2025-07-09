package br.uema.project.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.uema.project.project.entity.Category;
import br.uema.project.project.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> listAllCategories() {
        return repository.findAll();
    }

    public Category getCategoryById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Categoria não encontrada."));
    }

    public Category createCategory(Category category) {
        return repository.save(category);
    }

    public Category updateCategory(Long id, Category updatedCategory) {
        Category existing = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Categoria não encontrada."));

        existing.setName(updatedCategory.getName());
        existing.setDescription(updatedCategory.getDescription());
        return repository.save(existing);
    }

    public void deleteCategory(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Categoria não encontrada.");
        }
        repository.deleteById(id);
    }
}
