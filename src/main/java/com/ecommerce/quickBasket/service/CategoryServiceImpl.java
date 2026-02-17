package com.ecommerce.quickBasket.service;

import com.ecommerce.quickBasket.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    private List<Category> categories = new ArrayList<>();

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryId((long) (categories.size() + 1));
        categories.add(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Optional<Category> category = categories.stream().filter(c -> c.getCategoryId().equals(categoryId)).findFirst();
        if(category.isPresent()){
            categories.remove(category.get());
            return "Category deleted successfully";
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");


    }

    @Override
    public String updateCategory(Long categoryId, Category category) {
        Optional<Category> existingCategory = categories.stream().filter(c->c.getCategoryId().equals(categoryId)).findFirst();
        if(existingCategory.isPresent()){
            existingCategory.get().setCategoryName(category.getCategoryName());
            return "Category updated successfully";
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
        }

    }
}
