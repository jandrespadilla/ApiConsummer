package com.consumer.apis;

import com.consumer.interfaces.CategoryRestInterface;
import com.consumer.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.List;
@Component
public class CategoryRestApi implements CategoryRestInterface {
    private final String BASE_URL = "http://localhost:8080/api/categorias";
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public List<Category> getAllCategory() {
        try {
            @SuppressWarnings("unchecked")
            List<Category> categorys= restTemplate.exchange(BASE_URL, HttpMethod.GET,null,List.class).getBody();
            return categorys;
        }catch (Exception e){
            throw new RuntimeException("Error al obterner las categorias. "+e.getMessage(),e);
        }
    }

    @Override
    public Category getCategoryByID(String id) {
        try {
            String url= BASE_URL+"/"+id;
            return restTemplate.getForObject(url, Category.class);
        }catch (Exception e){
            throw new RuntimeException("Error al obterner la categoria. "+e.getMessage(),e);
        }
    }

    @Override
    public Category addCategory(Category category) {
        try {
            return restTemplate.postForObject(BASE_URL,category, Category.class);
        }catch (Exception e){
            throw new RuntimeException("Error al crear la categoria. "+e.getMessage(),e);
        }
    }

    @Override
    public Category updateCategory(Category category) {
        try {
            String url = BASE_URL+"/"+category.getId();
            restTemplate.put(url,category);
            return category;
        }catch (Exception e){
            throw new RuntimeException("Error al actualizar la categoria. "+e.getMessage(),e);
        }
    }

    @Override
    public void deleteCategory(String id) {
        try {
            String url = BASE_URL+"/"+id;
            restTemplate.delete(url);
        }catch (Exception e){
            throw new RuntimeException("Error al borrar la categoria. "+e.getMessage(),e);
        }
    }
}
