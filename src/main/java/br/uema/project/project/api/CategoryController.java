package br.uema.project.project.api;

import br.uema.project.project.entity.Category;
import br.uema.project.project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    @Autowired
    private CategoryService service;

    @GetMapping("/list-all")
    public List<Category> listAllCategories()
    {
        return service.listAllCategories();
    }
}
