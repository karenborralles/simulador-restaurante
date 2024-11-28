package org.example.proyectosimuladork.models;

import org.example.proyectosimuladork.controladores.MainController;

public class RecepcionistaModel implements Runnable{
    private final MainController mainController;
    private final RestaurantModel restaurantModel;

    public RecepcionistaModel(MainController mainController, RestaurantModel restaurantModel) {
        this.mainController = mainController;
        this.restaurantModel = restaurantModel;
    }

    @Override
    public void run() {

    }

    public synchronized void permitirEntradaCliente() throws InterruptedException {
        synchronized (restaurantModel) {

            while (restaurantModel.mesasOcupadas == 6) {
                System.out.println("Restaurant lleno");
                restaurantModel.wait();
            }

            restaurantModel.mesasOcupadas++;

            //buscar mesa libre
            //Comenzal entra a la mesa libre

            if (restaurantModel.mesasOcupadas < 6) {
                restaurantModel.notify();
            }
        }
    }
}
