package com.consumer.controller;

import com.consumer.models.DetailsSell;
import com.consumer.models.User;
import com.consumer.services.DetailSellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detailsell")
public class DetailSellController {
    @Autowired
    private DetailSellService detailSellService;

    @GetMapping(value="/", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<DetailsSell>> getAllDetaillSell(){
        try {
            List<DetailsSell> detailsSells = detailSellService.getAllDetailSell();
            return ResponseEntity.ok(detailsSells);
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping(value="/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<DetailsSell> getDetailsSellById(@PathVariable String id){
        try {
            DetailsSell detailSellById = detailSellService.getDetailSellById(id);
            return ResponseEntity.ok(detailSellById);
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    @PostMapping(value="/", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<DetailsSell> addDetailsSell(@RequestBody DetailsSell detailsSell){
        try {
            DetailsSell detailSell = detailSellService.addDetailSell(detailsSell);
            return ResponseEntity.ok(detailSell);
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping(value = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<DetailsSell> updateDetailSell(@PathVariable String id,@RequestBody DetailsSell detailsSell){
        try {
            detailsSell.setId(id);
            DetailsSell updatedDetailsSell = detailSellService.updateDetailSell(detailsSell);
            return ResponseEntity.ok(updatedDetailsSell);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteDetailSell(@PathVariable String id) {
        try {
            detailSellService.deleteDetailSell(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
