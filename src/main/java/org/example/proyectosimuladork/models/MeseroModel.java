package org.example.proyectosimuladork.models;

import org.example.proyectosimuladork.controladores.MainController;

public class MeseroModel implements Runnable{
    private final MainController mainController;
    private final RestaurantModel restaurantModel;

    public MeseroModel(MainController mainController, RestaurantModel restaurantModel) {
        this.mainController = mainController;
        this.restaurantModel = restaurantModel;
    }

    @Override
    public void run() {
        while (true) {
            try {
                servirComida();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public synchronized void servirComida() throws InterruptedException {
        synchronized (restaurantModel) {
            while (restaurantModel.mesasOcupadas == 0) {
                restaurantModel.wait();
            }

            if (!restaurantModel.bufferComidas.isEmpty()) {
                Thread.sleep(2000);

                ComidaModel comida = restaurantModel.bufferComidas.poll();
                System.out.println("Mesero lleva la comida al comensal: " + comida.getOrden());

                Integer[] posicion = restaurantModel.posicionesDeMesas.get(comida.getOrden());
                mainController.moverMesero(posicion[0]+50, posicion[1]+50, 2);
                Thread.sleep(2000);

                restaurantModel.notify();
            }
        }
    }
}
