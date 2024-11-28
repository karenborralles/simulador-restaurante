package org.example.proyectosimuladork.models;

import org.example.proyectosimuladork.vistas.Cliente;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class RestaurantModel {
    private int capacidad;
    public Queue<OrdenModel> bufferOrdenes = new LinkedList<>();
    public HashMap<ClienteModel, Cliente> colaEspera = new HashMap<>();
    public int mesasOcupadas = 0;

    public RestaurantModel() {
    }
}
