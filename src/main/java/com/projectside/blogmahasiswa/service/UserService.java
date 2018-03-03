package com.projectside.blogmahasiswa.service;

import com.projectside.blogmahasiswa.domain.User;
import com.projectside.blogmahasiswa.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {

    User save(User user);

    Page<User> findAll(Pageable pageable);

    Optional<User> findById(String id);

}
