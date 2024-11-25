package com.consumer.models;

import lombok.Data;

@Data
public class User {
    private String id;
    private String nombre;
    private String apellido;
    private String dni;
    private String direccion;
    private String email;
}
