package com.consumer.services;

import com.consumer.apis.SellRestApi;
import com.consumer.interfaces.SellRestInterface;
import com.consumer.models.Sell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SellService implements SellRestInterface {
    @Autowired
    private SellRestApi sellRestApi;
    @Override
    public List<Sell> getAllSell() {
        return sellRestApi.getAllSell();
    }

    @Override
    public Sell getSellByID(String id) {
        return sellRestApi.getSellByID(id);
    }

    @Override
    public Sell addSell(Sell sell) {
        return sellRestApi.addSell(sell);
    }

    @Override
    public Sell updateSell(Sell sell) {
        return sellRestApi.updateSell(sell);
    }

    @Override
    public void deleteSell(String id) {
            sellRestApi.deleteSell(id);
    }
}
