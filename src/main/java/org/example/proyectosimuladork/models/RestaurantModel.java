package org.example.proyectosimuladork.models;

import org.example.proyectosimuladork.vistas.Cliente;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class RestaurantModel {
    public Queue<OrdenModel> bufferOrdenes = new LinkedList<>();
    public Queue<ComidaModel> bufferComidas = new LinkedList<>();
    public HashMap<ClienteModel, Cliente> colaEspera = new HashMap<>();
    public int mesasOcupadas = 0;
    public HashMap<Integer, Integer[]> posicionesDeMesas = new HashMap<>();
    public HashMap<Integer, Integer> disponibilidadMesas = new HashMap<>();



    public RestaurantModel() {
        llenarPosicionesDeMesas();
    }

    public void llenarPosicionesDeMesas(){
        // mesa izquiera linea 1
        posicionesDeMesas.put(1, new Integer[]{100, -170});
        // mesa izquierda linea 2
        posicionesDeMesas.put(2, new Integer[]{100, 0});
        // mesa izquierda linea 3
        posicionesDeMesas.put(3, new Integer[]{100, 150});
        // mesa derecha linea 1
        posicionesDeMesas.put(4, new Integer[]{330, -170});
        // mesa derecha linea 2
        posicionesDeMesas.put(5, new Integer[]{330, 0});
        // mesa derecha linea 3
        posicionesDeMesas.put(6, new Integer[]{330, 150});

        disponibilidadMesas.put(1, 0);
        disponibilidadMesas.put(2, 0);
        disponibilidadMesas.put(3, 0);
        disponibilidadMesas.put(4, 0);
        disponibilidadMesas.put(5, 0);
        disponibilidadMesas.put(6, 0);
    }

    public int buscarMesaLibre(){
        for (HashMap.Entry<Integer, Integer> entry : disponibilidadMesas.entrySet()) {
            if (entry.getValue() == 0) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
