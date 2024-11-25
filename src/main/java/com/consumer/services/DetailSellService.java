package com.consumer.services;

import com.consumer.apis.DetailsSellRestApi;
import com.consumer.interfaces.DetailsSellRestInterface;
import com.consumer.models.DetailsSell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DetailSellService implements DetailsSellRestInterface {
    @Autowired
    private DetailsSellRestApi detailsSellRestApi;
    @Override
    public List<DetailsSell> getAllDetailSell() {
        return detailsSellRestApi.getAllDetailSell();
    }

    @Override
    public DetailsSell getDetailSellById(String id) {
        return detailsSellRestApi.getDetailSellById(id);
    }

    @Override
    public DetailsSell addDetailSell(DetailsSell detailSell) {
        return detailsSellRestApi.addDetailSell(detailSell);
    }

    @Override
    public DetailsSell updateDetailSell(DetailsSell detailSell) {
        return detailsSellRestApi.updateDetailSell(detailSell);
    }

    @Override
    public void deleteDetailSell(String id) {
            detailsSellRestApi.deleteDetailSell(id);
    }
}
