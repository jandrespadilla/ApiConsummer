package com.consumer.apis;

import com.consumer.interfaces.DetailsSellRestInterface;
import com.consumer.models.DetailsSell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.List;
@Component
public class DetailsSellRestApi implements DetailsSellRestInterface {
    private final String BASE_URL = "http://localhost:8080/api/ventadetalle";
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public List<DetailsSell> getAllDetailSell() {
        try {
            @SuppressWarnings("unchecked")
            List<DetailsSell> detailsSells= restTemplate.exchange(BASE_URL, HttpMethod.GET,null,List.class).getBody();
            return detailsSells;
        }catch (Exception e){
            throw new RuntimeException("Error al obterner los detalles de ventas. "+e.getMessage(),e);
        }
    }

    @Override
    public DetailsSell getDetailSellById(String id) {
        try {
            String url= BASE_URL+"/"+id;
            return restTemplate.getForObject(url, DetailsSell.class);
        }catch (Exception e){
            throw new RuntimeException("Error al obterner el detalle de venta. "+e.getMessage(),e);
        }
    }

    @Override
    public DetailsSell addDetailSell(DetailsSell detailSell) {
        try {
            return restTemplate.postForObject(BASE_URL,detailSell, DetailsSell.class);
        }catch (Exception e){
            throw new RuntimeException("Error al crear el detalla de venta. "+e.getMessage(),e);
        }
    }

    @Override
    public DetailsSell updateDetailSell(DetailsSell detailSell) {
        try {
            String url = BASE_URL+"/"+detailSell.getId();
            restTemplate.put(url,detailSell);
            return detailSell;
        }catch (Exception e){
            throw new RuntimeException("Error al actualizar el detalle de venta. "+e.getMessage(),e);
        }
    }

    @Override
    public void deleteDetailSell(String id) {
        try {
            String url = BASE_URL+"/"+id;
            restTemplate.delete(url);
        }catch (Exception e){
            throw new RuntimeException("Error al borrar el detalle de venta. "+e.getMessage(),e);
        }
    }
}
