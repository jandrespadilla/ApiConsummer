package com.consumer.interfaces;

import com.consumer.models.Category;

import java.util.List;

public interface CategoryRestInterface {
    public List<Category> getAllCategory();
    public Category getCategoryByID(String id);
    public Category addCategory(Category category);
    public Category updateCategory(Category category);
    public void deleteCategory(String id);
}
