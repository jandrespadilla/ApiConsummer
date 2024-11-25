package com.consumer.models;

import lombok.Data;

import java.util.List;

@Data
public class Sell {
        private String id;
        private String numeroFactura;
        private String fechaVenta;
        private User usuario;
        private String totalVenta;
        private String formaPago;
        private List<DetailsSell> detalle;
}
