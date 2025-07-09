package br.uema.project.project.service;

import br.uema.project.project.entity.User;
import br.uema.project.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

        if (user.getCpf() == null || user.getCpf().isBlank()) {
            throw new RuntimeException("CPF é obrigatório.");
        }

        if (repository.existsByCpf(user.getCpf())) {
            throw new RuntimeException("CPF já cadastrado.");
        }

        user.setRegistrationDate(java.time.LocalDate.now());

        user.setActive(true);  // adiciona aqui para evitar valor nulo

        repository.save(user);
    }

     public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public void update(Long id, User user) {
        User existing = findById(id);           //not being used yet
        user.setId(id);
        repository.save(user);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
