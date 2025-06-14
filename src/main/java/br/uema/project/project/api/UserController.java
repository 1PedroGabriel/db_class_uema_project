package br.uema.project.project.api;

import br.uema.project.project.entity.User;
import br.uema.project.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/create")
    public void createUser(User user)
    {
        service.create(user);
    }
}
