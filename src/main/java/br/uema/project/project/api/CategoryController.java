package br.uema.project.project.api;

import br.uema.project.project.entity.Category;
import br.uema.project.project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("/list-all")
    public List<Category> listAllCategories() {
        return service.listAllCategories();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return service.getCategoryById(id);
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return service.createCategory(category);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category category) {
        return service.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        service.deleteCategory(id);
    }
}
