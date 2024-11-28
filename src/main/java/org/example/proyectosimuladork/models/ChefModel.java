package org.example.proyectosimuladork.models;

import org.example.proyectosimuladork.controladores.MainController;

public class ChefModel implements Runnable {
    private MainController mainController;
    public ChefModel(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void run() {

    }
}
