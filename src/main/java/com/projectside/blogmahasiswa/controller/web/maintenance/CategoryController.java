package com.projectside.blogmahasiswa.controller.web.maintenance;

import com.projectside.blogmahasiswa.domain.Category;
import com.projectside.blogmahasiswa.dto.CategoryDto;
import com.projectside.blogmahasiswa.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Optional;

import static org.springframework.data.domain.PageRequest.of;

@Controller
@RequestMapping(path = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/create")
    public String createCategory(Model model) {
        model.addAttribute("category", new Category());
        return "/categoryModule/createCategory";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Category category, Model model) {
        category = categoryService.save(category);
        CategoryDto categoryDto = toDto(category);
        categoryDto.setRespCode("succInsert");
        categoryDto.setRespResult("Y");
        categoryDto.setRespMessage("Successful of creating new Category");
        model.addAttribute("categoryDto", categoryDto);
        return "/categoryModule/detailCategory";
    }

    @GetMapping("/list")
    public String listCategory(Model model,
                               @RequestParam(name = "page", defaultValue = "0") int page,
                               @RequestParam(name = "size", defaultValue = "10") int size,
                               @RequestParam(name = "direction", defaultValue = "ASC") Sort.Direction direction,
                               @RequestParam(name = "sortBy", defaultValue = "id") String sortBy) { ;
        model.addAttribute("pageCategoryDto", categoryService.findAll(of(page, size, direction, sortBy)).map(this::toDto));
        return "/categoryModule/listCategory";
    }

    @GetMapping("/detail/{id}")
    public ModelAndView getDetailCategory(@PathVariable String id, ModelMap model) {
        Category category = categoryService.findById(id).get();
        CategoryDto categoryDto = toDto(category);
        categoryDto.setRespResult("Y");
        model.addAttribute("categoryDto", categoryDto);
        return new ModelAndView("/categoryModule/detailCategory", model);
    }

    private CategoryDto toDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        BeanUtils.copyProperties(category, categoryDto);
        return categoryDto;
    }

    private Category toModel(CategoryDto categoryDto) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDto, category);
        return category;
    }
}
