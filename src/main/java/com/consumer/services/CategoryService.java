package com.consumer.services;

import com.consumer.apis.CategoryRestApi;
import com.consumer.interfaces.CategoryRestInterface;
import com.consumer.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements CategoryRestInterface {
    @Autowired
    private CategoryRestApi categoryRestApi;
    @Override
    public List<Category> getAllCategory() {
        return categoryRestApi.getAllCategory();
    }

    @Override
    public Category getCategoryByID(String id) {
        return categoryRestApi.getCategoryByID(id);
    }

    @Override
    public Category addCategory(Category category) {
        return categoryRestApi.addCategory(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRestApi.updateCategory(category);
    }

    @Override
    public void deleteCategory(String id) {
            categoryRestApi.deleteCategory(id);
    }
}
