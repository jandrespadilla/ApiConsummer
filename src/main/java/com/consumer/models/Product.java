package com.consumer.models;

import lombok.Data;

@Data
public class Product {
        private String id;
        private String nombre;
        private String descripcion;
        private String stock;
        private String precio;
}
