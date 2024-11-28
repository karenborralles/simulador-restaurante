package org.example.proyectosimuladork.models;

import javafx.application.Platform;
import org.example.proyectosimuladork.controladores.MainController;

public class ClienteModel implements Runnable {
    private MainController mainController;
    private RecepcionistaModel recepcionistaModel;
    private double posicionX;
    private double posicionY;


    public ClienteModel(MainController mainController, double posicionX, double posicionY) {
        this.mainController = mainController;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    @Override
    public void run() {
        while (true) {
            Platform.runLater(() -> mainController.llamarMesero(posicionX, posicionY, 4));
        }
    }

    public double getPosicionX() {
        return posicionX;
    }

    public double getPosicionY() {
        return posicionY;
    }
}
