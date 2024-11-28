package org.example.proyectosimuladork.controladores;

import javafx.application.Platform;
import org.example.proyectosimuladork.models.*;
import org.example.proyectosimuladork.vistas.Chef;
import org.example.proyectosimuladork.vistas.Cliente;
import org.example.proyectosimuladork.vistas.Mesero;
import org.example.proyectosimuladork.vistas.Recepcionista;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class MainController {
    //Entidades
    private Chef chefEntity = new Chef();
    private Mesero meseroEntity = new Mesero();
    private Recepcionista recepcionistaEntity = new Recepcionista();
    private HashMap<Integer, Integer[]> posicionesDeMesas = new HashMap<>();

    public void iniciar(){
        chefEntity.crearChef(613, 40);
        meseroEntity.crearMesero(390, 210);
        recepcionistaEntity.crearRecepcionista(40, 0);

        RestaurantModel restaurantModel = new RestaurantModel();

        //hilos
        Thread chefThread = new Thread(new ChefModel(this));
        Thread meseroThread = new Thread(new MeseroModel(this));
        Thread recepcionistaThread = new Thread(new RecepcionistaModel(this, restaurantModel));

        chefThread.start();
        meseroThread.start();
        recepcionistaThread.start();

        int id = 1;

        new Thread(() -> {
            try {
                while (true) {
                    System.out.println("Nuevo CLiente");

                    ClienteModel clienteModel = new ClienteModel(this, 0, 8);
                    Cliente cliente = new Cliente();
                    restaurantModel.colaEspera.put(clienteModel, cliente);

                    Platform.runLater(() -> cliente.crearCliente(clienteModel.getPosicionX(), clienteModel.getPosicionY()));

                    int poissonRes = generarNumConPoisson(5);
                    Thread.sleep(poissonRes * 1000L);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public int generarNumConPoisson(double lambda){
        double L = Math.exp(-lambda);
        double p = 1.0;
        int k = 0;
        do{
            k++;
            p *= Math.random();
        } while (p > L);
        return k-1;
    }

    public void llamarMesero(double x, double y, int tiempo){
        System.out.println("Llamando mesero");
        meseroEntity.moverMesero(x, y, tiempo);
    }
}
