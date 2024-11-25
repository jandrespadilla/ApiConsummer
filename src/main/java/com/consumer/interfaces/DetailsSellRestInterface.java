package com.consumer.interfaces;

import com.consumer.models.DetailsSell;

import java.util.List;

public interface DetailsSellRestInterface {
    public List<DetailsSell> getAllDetailSell();
    public DetailsSell getDetailSellById(String id);
    public DetailsSell addDetailSell(DetailsSell detailSell);
    public DetailsSell updateDetailSell(DetailsSell detailSell);
    public void deleteDetailSell(String id);
}
