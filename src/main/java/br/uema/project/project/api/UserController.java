package br.uema.project.project.api;

import br.uema.project.project.entity.User;
import br.uema.project.project.service.UserService;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/create")
    public void createUser(@RequestBody User user)
    {
        service.create(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return service.findAll();
    }
    
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return service.findById(id);
    } 
    
    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User user) {
        service.update(id, user);
    }
    
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        service.delete(id);
    }
}
