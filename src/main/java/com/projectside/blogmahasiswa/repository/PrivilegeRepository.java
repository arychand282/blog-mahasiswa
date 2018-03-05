package com.projectside.blogmahasiswa.repository;

import com.projectside.blogmahasiswa.domain.Privilege;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrivilegeRepository extends PagingAndSortingRepository<Privilege, String> {

    Optional<Privilege> findById(String id);

}
