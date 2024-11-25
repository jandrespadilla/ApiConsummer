package com.consumer.models;

import lombok.Data;

@Data
public class DetailsSell {
    private String id;
    private Sell ventaCabecera;
    private Product producto;
    private String precioProducto;
    private String cantidadProducto;
    private String totalDetalle;
}
