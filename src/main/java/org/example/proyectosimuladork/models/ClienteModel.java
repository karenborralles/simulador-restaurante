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

    public ClienteModel(MainController mainController, double posicionX, double posicionY, RestaurantModel restaurantModel) {
        this.mainController = mainController;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.restaurantModel = restaurantModel;
    }

    @Override
    public void run() {
        while (flag) {
            //Platform.runLater(() -> mainController.llamarMesero(posicionX, posicionY, 4));
            try {
                System.out.println("CLiente comiendo");
                Thread.sleep(4000);
                System.out.println("Cliente dejando restaurant");

                restaurantModel.mesasOcupadas--;

                flag = false;
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
}
