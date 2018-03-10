package com.projectside.blogmahasiswa.repository;

import com.projectside.blogmahasiswa.domain.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, String> {

    Page<Category> findByDeleteFlag(boolean deleteFlag, Pageable pageable);

    Optional<Category> findByIdAndDeleteFlag(String id, boolean deleteFlag);

}
