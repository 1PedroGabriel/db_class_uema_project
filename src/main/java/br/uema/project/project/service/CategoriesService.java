package br.uema.project.project.service;

import br.uema.project.project.entity.Categories;
import br.uema.project.project.repository.CategoriesRepository;
import org.aspectj.weaver.patterns.TypeCategoryTypePattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService {

    @Autowired
    private CategoriesRepository repository;

    public List<Categories> listAllCategories()
    {
        return repository.findAll();
    }
}
