package org.example.proyectosimuladork.models;

import javafx.application.Platform;
import org.example.proyectosimuladork.controladores.MainController;

public class ClienteModel implements Runnable {
    private MainController mainController;
    private RecepcionistaModel recepcionistaModel;
    private double posicionX;
    private double posicionY;
    private boolean flag = true;
    private final RestaurantModel restaurantModel;
    private int idMesa;
    private boolean ordenServida;
    private boolean ordenPedida;

    public ClienteModel(MainController mainController, double posicionX, double posicionY, RestaurantModel restaurantModel) {
        this.mainController = mainController;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.restaurantModel = restaurantModel;
    }

    @Override
    public void run() {
        while (flag) {
            try {
                if (!ordenPedida){
                    mainController.llamarMesero(idMesa, posicionX, posicionY, 2);
                    ordenPedida = true;
                }
                if (ordenServida) {
                    mainController.moverMeseroACheff(idMesa);
                    System.out.println("CLiente comiendo");
                    Thread.sleep(2000);
                    System.out.println("Cliente dejando restaurant");

                    restaurantModel.mesasOcupadas--;
                    restaurantModel.disponibilidadMesas.put(idMesa, 0);
                    //desaparecer el entity

                    flag = false;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public double getPosicionX() {
        return posicionX;
    }

    public double getPosicionY() {
        return posicionY;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public void setOrdenServida(boolean ordenServida) {
        this.ordenServida = ordenServida;
    }
}
