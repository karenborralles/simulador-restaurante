package org.example.proyectosimuladork.models;

import org.example.proyectosimuladork.controladores.MainController;
import org.example.proyectosimuladork.vistas.Cliente;

import java.util.Map;

public class RecepcionistaModel implements Runnable{
    private final MainController mainController;
    private final RestaurantModel restaurantModel;

    public RecepcionistaModel(MainController mainController, RestaurantModel restaurantModel) {
        this.mainController = mainController;
        this.restaurantModel = restaurantModel;
    }

    @Override
    public void run() {
        while(true){
            try {
                if (!restaurantModel.colaEspera.isEmpty()) {
                    System.out.println("iniciando");
                    permitirEntradaCliente();
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void permitirEntradaCliente() throws InterruptedException {
        synchronized (restaurantModel) {
            while (restaurantModel.mesasOcupadas == 6) {
                System.out.println("Restaurant lleno");
                restaurantModel.wait();
            }
            Map.Entry<ClienteModel, Cliente> firstEntry = restaurantModel.colaEspera.entrySet().iterator().next();

            System.out.println("Cliente entrando: " + firstEntry.getKey());
            restaurantModel.colaEspera.remove(firstEntry.getKey());

            //buscar mesa libre
            //Comenzal entra a la mesa libre
            ClienteModel client = firstEntry.getKey();

            Thread clientThread = new Thread(client);
            clientThread.start();

            restaurantModel.mesasOcupadas++;

            if (restaurantModel.mesasOcupadas < 6) {
                System.out.println("Notificando");
                restaurantModel.notifyAll();
            }
        }
    }
}
