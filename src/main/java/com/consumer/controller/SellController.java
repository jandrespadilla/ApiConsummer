package com.consumer.controller;

import com.consumer.models.Sell;

import com.consumer.services.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sell")
public class SellController {
    @Autowired
    private SellService sellService;
    @GetMapping(value="/", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Sell>> getAllSell(){
        try {
            List<Sell> sells = sellService.getAllSell();
            return ResponseEntity.ok(sells);
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping(value="/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Sell> getSellById(@PathVariable String id){
        try {
            Sell sell = sellService.getSellByID(id) ;
            return ResponseEntity.ok(sell);
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    @PostMapping(value="/", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Sell> addSell(@RequestBody Sell sell){
        try {
            Sell createdSell1 = sellService.addSell(sell);
            return ResponseEntity.ok(createdSell1);
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    @PutMapping(value = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Sell> updateSell(@PathVariable String id,@RequestBody Sell sell){
        try {
            sell.setId(id);
            Sell updateSell = sellService.updateSell(sell);
            return ResponseEntity.ok(updateSell);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteSell(@PathVariable String id){
        try {
            sellService.deleteSell(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
