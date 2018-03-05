package com.projectside.blogmahasiswa.service.impl;

import com.projectside.blogmahasiswa.domain.Privilege;
import com.projectside.blogmahasiswa.repository.PrivilegeRepository;
import com.projectside.blogmahasiswa.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Override
    public Optional<Privilege> findById(String id) {
        return privilegeRepository.findById(id);
    }
}
