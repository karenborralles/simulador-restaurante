package org.example.proyectosimuladork.models;

import org.example.proyectosimuladork.controladores.MainController;

public class ChefModel implements Runnable {
    private MainController mainController;
    private final RestaurantModel restaurantModel;
    
    public ChefModel(MainController mainController, RestaurantModel restaurantModel) {
        this.mainController = mainController;
        this.restaurantModel = restaurantModel;
    }

    @Override
    public void run() {
        while (true) {
            try {
                cocinar();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void cocinar() throws InterruptedException {
        synchronized (restaurantModel) {
            while (restaurantModel.bufferOrdenes.isEmpty()) {
                System.out.println("No hay ordenes");
                restaurantModel.wait();
            }

            if (restaurantModel.bufferComidas.size() == 1) {
                System.out.println();
                restaurantModel.notify();
            }

            if (!restaurantModel.bufferOrdenes.isEmpty()) {
                OrdenModel ordenModel = restaurantModel.bufferOrdenes.poll();
                System.out.println("Cocinando");
                Thread.sleep(2000);
                restaurantModel.bufferComidas.add(new ComidaModel(ordenModel.getNumero()));
            }
        }
    }
}
