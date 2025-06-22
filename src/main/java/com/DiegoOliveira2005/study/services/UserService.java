package com.DiegoOliveira2005.study.services;

import com.DiegoOliveira2005.study.entities.User;
import com.DiegoOliveira2005.study.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User insert(User obj) {
        return repository.save(obj);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        return repository.findById(id).get  ();
    }
}
