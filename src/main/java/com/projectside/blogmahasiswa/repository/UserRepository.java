package com.projectside.blogmahasiswa.repository;

import com.projectside.blogmahasiswa.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, String> {

    Page<User> findByDeleteFlag(boolean deleteFlag, Pageable pageable);

    Optional<User> findByIdAndDeleteFlag(String id, boolean deleteFlag);

    User findByEmailAndDeleteFlag(String email, boolean deleteFlag);

}
