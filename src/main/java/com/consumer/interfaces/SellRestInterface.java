package com.consumer.interfaces;

import com.consumer.models.Sell;

import java.util.List;

public interface SellRestInterface {
    public List<Sell> getAllSell();
    public Sell getSellByID(String id);
    public Sell addSell(Sell sell);
    public Sell updateSell(Sell sell);
    public void deleteSell(String id);
}
