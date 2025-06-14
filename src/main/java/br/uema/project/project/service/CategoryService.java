package br.uema.project.project.service;

import br.uema.project.project.entity.Category;
import br.uema.project.project.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService {

    @Autowired
    private CategoriesRepository repository;

    public List<Category> listAllCategories()
    {
        return repository.findAll();
    }
}
