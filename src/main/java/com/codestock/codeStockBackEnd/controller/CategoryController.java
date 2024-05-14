package com.codestock.codeStockBackEnd.controller;

import com.codestock.codeStockBackEnd.service.ICategory;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class represents the Category Controller in the application.
 * It provides endpoints for managing categories.
 * It is annotated with @RestController to indicate that it's a RESTful web service controller.
 * The @RequestMapping annotation is used to map web requests onto specific handler methods.
 * The @Tag annotation is used to add metadata to the API about the controller.
 *
 * @author Yesid-Robayo
 * @version 1.0
 * @see com.codestock.codeStockBackEnd.service.ICategory
 * @see org.springframework.web.bind.annotation.RestController
 * @see org.springframework.web.bind.annotation.RequestMapping
 * @see org.springframework.web.bind.annotation.GetMapping
 * @see io.swagger.v3.oas.annotations.tags.Tag
 */
@RestController
@RequestMapping("/api/v1")
@Tag(name = "Category", description = "Category Controller")
public class CategoryController {
    /**
     * The service that is used to interact with the Category data.
     */
    private final ICategory categoryService;

    /**
     * Constructs a new CategoryController with the specified Category service.
     *
     * @param categoryService The service to be used by the CategoryController.
     */
    @Autowired
    public CategoryController(ICategory categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * This method is used to get all categories.
     * It is mapped to the HTTP GET method and the URL /api/v1/category.
     *
     * @return A ResponseEntity that contains the list of all categories.
     */
    @GetMapping("/category")
    public ResponseEntity<?> getAllCategories() {
        return ResponseEntity.ok(categoryService.findAllCategory());
    }
}