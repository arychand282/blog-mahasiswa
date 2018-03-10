package com.projectside.blogmahasiswa.service.impl;

import com.projectside.blogmahasiswa.domain.Category;
import com.projectside.blogmahasiswa.repository.CategoryRepository;
import com.projectside.blogmahasiswa.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public Category save(Category category) {
        category.setCreatedBy("arychand");
        category.setDateCreated(new Date());
        return categoryRepository.save(category);
    }

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findByDeleteFlag(false, pageable);
    }

    @Override
    public Optional<Category> findById(String id) {
        return categoryRepository.findByIdAndDeleteFlag(id, false);
    }
}
