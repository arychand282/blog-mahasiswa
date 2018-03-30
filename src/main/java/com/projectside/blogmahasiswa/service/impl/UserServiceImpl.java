package com.projectside.blogmahasiswa.service.impl;

import com.projectside.blogmahasiswa.domain.Role;
import com.projectside.blogmahasiswa.domain.User;
import com.projectside.blogmahasiswa.repository.RoleRepository;
import com.projectside.blogmahasiswa.repository.UserRepository;
import com.projectside.blogmahasiswa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setDeleteFlag(false);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
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

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmailAndDeleteFlag(email, false);
    }

}
