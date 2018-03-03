package com.projectside.blogmahasiswa.service.impl;

import com.projectside.blogmahasiswa.domain.User;
import com.projectside.blogmahasiswa.dto.UserDto;
import com.projectside.blogmahasiswa.repository.UserRepository;
import com.projectside.blogmahasiswa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        user.setDeleteFlag(false);
        return userRepository.save(user);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findByDeleteFlag(false, pageable);
    }

    @Override
    public Optional<User> findById(String id) {
        return userRepository.findByIdAndDeleteFlag(id, false);
    }
}
