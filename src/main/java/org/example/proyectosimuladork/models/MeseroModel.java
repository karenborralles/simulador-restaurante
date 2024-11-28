package org.example.proyectosimuladork.models;

import org.example.proyectosimuladork.controladores.MainController;

public class MeseroModel implements Runnable{
    private final MainController mainController;

    public MeseroModel(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void run() {

    }
}
