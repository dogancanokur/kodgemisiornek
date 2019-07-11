package com.kodgemisi.ornek.repository;

import com.kodgemisi.ornek.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User getUserByUsername(String username);

}
