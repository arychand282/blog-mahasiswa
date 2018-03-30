package com.projectside.blogmahasiswa.repository;

import com.projectside.blogmahasiswa.domain.Role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrivilegeRepository extends PagingAndSortingRepository<Role, String> {

    Optional<Role> findById(String id);

}
