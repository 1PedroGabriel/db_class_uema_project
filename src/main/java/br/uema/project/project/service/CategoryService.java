package br.uema.project.project.service;

import br.uema.project.project.entity.Category;
import br.uema.project.project.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> listAllCategories()
    {
        return repository.findAll();
    }
}
