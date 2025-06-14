package br.uema.project.project.api;

import br.uema.project.project.entity.Category;
import br.uema.project.project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("/list-all")
    public List<Category> listAllCategories()
    {
        return service.listAllCategories();
    }
}
