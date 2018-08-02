package com.praksa.ivan.service.user;

import java.util.Collection;
import java.util.Optional;

import com.praksa.ivan.domain.User;
import com.praksa.ivan.domain.UserCreateForm;

public interface UserService {

    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

    User create(UserCreateForm form);

}
