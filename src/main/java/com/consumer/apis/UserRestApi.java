package com.consumer.apis;

import com.consumer.interfaces.UserRestInterface;
import com.consumer.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class UserRestApi implements UserRestInterface {

    private final String BASE_URL = "http://localhost:8080/api/usuarios";
    @Autowired
    private  RestTemplate restTemplate;



    @Override
    public List<User> getAllUser() {
        try {
            @SuppressWarnings("unchecked")
            List<User> users= restTemplate.exchange(BASE_URL, HttpMethod.GET,null,List.class).getBody();
            return users;
        }catch (Exception e){
            throw new RuntimeException("Error al obterner los usuarios. "+e.getMessage(),e);
        }
    }

    @Override
    public User getUserById(String id) {
        try {
            String url= BASE_URL+"/"+id;
            return restTemplate.getForObject(url,User.class);
        }catch (Exception e){
            throw new RuntimeException("Error al obterner el usuarios. "+e.getMessage(),e);
        }
    }

    @Override
    public User addUser(User user) {
        try {
            String url= BASE_URL+"/createUsuario";
            return restTemplate.postForObject(url,user,User.class);
        }catch (Exception e){
            throw new RuntimeException("Error al crear el usuarios. "+e.getMessage(),e);
        }

    }

    @Override
    public User updateUser(User user) {
        try {
            String url = BASE_URL+"/"+user.getId();
            restTemplate.put(url,user);
            return user;
        }catch (Exception e){
            throw new RuntimeException("Error al actualizar el usuarios. "+e.getMessage(),e);
        }
    }

    @Override
    public void deleteUser(String id) {
        try {
            String url = BASE_URL+"/deleteusuario/"+id;
            restTemplate.delete(url);
        }catch (Exception e){
            throw new RuntimeException("Error al borrar el usuarios. "+e.getMessage(),e);
        }
    }
}
