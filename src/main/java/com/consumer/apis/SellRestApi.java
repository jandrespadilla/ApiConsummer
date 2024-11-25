package com.consumer.apis;

import com.consumer.interfaces.SellRestInterface;
import com.consumer.models.Sell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Component
public class SellRestApi implements SellRestInterface {
    private final String BASE_URL = "http://localhost:8080/api/ventacabecera";
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public List<Sell> getAllSell() {
        try {
            @SuppressWarnings("unchecked")
            List<Sell> sells= restTemplate.exchange(BASE_URL, HttpMethod.GET,null,List.class).getBody();
            return sells;
        }catch (Exception e){
            throw new RuntimeException("Error al obterner las ventas. "+e.getMessage(),e);
        }
    }

    @Override
    public Sell getSellByID(String id) {
        try {
            String url= BASE_URL+"/"+id;
            return restTemplate.getForObject(url, Sell.class);
        }catch (Exception e){
            throw new RuntimeException("Error al obterner la venta. "+e.getMessage(),e);
        }
    }

    @Override
    public Sell addSell(Sell sell) {
        try {
            return restTemplate.postForObject(BASE_URL,sell, Sell.class);
        }catch (Exception e){
            throw new RuntimeException("Error al crear la venta. "+e.getMessage(),e);
        }
    }

    @Override
    public Sell updateSell(Sell sell) {
        try {
            String url = BASE_URL+"/"+sell.getId();
            restTemplate.put(url,sell);
            return sell;
        }catch (Exception e){
            throw new RuntimeException("Error al actualizar la venta. "+e.getMessage(),e);
        }
    }

    @Override
    public void deleteSell(String id) {
        try {
            String url = BASE_URL+"/"+id;
            restTemplate.delete(url);
        }catch (Exception e){
            throw new RuntimeException("Error al borrar la venta. "+e.getMessage(),e);
        }
    }
}
