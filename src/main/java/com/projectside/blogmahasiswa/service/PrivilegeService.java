package com.projectside.blogmahasiswa.service;

import com.projectside.blogmahasiswa.domain.Privilege;

import java.util.Optional;

public interface PrivilegeService {

    Optional<Privilege> findById(String id);

}
