package br.uema.project.project.service;

import br.uema.project.project.entity.User;
import br.uema.project.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    @Autowired
    private UserRepository repository;

    public void create(User user)
    {
        if (repository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email já cadastrado.");
        }

        user.setRegistrationDate(java.time.LocalDate.now());

        repository.save(user);
    }
}
