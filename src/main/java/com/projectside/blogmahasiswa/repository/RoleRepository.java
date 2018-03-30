package com.projectside.blogmahasiswa.repository;

import com.projectside.blogmahasiswa.domain.Role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends PagingAndSortingRepository<Role, String> {
    Role findByRole(String role);
}
