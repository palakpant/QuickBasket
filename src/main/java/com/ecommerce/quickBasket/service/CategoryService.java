package com.ecommerce.quickBasket.service;

import com.ecommerce.quickBasket.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    void createCategory(Category category);
    String deleteCategory(Long categoryId);

}
