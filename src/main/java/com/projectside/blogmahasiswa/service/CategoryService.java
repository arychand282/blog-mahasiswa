package com.projectside.blogmahasiswa.service;

import com.projectside.blogmahasiswa.domain.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CategoryService {

    Category save(Category category);

    Page<Category> findAll(Pageable pageable);

    Optional<Category> findById(String id);

}
