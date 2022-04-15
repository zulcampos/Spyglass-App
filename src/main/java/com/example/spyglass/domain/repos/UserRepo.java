package com.example.spyglass.domain.repos;


import com.example.spyglass.domain.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

    public interface UserRepo extends CrudRepository<User, Long> {
        Optional<User> findAllById(Long id);
}
