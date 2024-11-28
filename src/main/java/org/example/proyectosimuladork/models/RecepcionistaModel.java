package org.example.proyectosimuladork.models;

import javafx.application.Platform;
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
                Thread.sleep(1000);
                if (!restaurantModel.colaEspera.isEmpty()) {
                    System.out.println("iniciando");
                    permitirEntradaCliente();
                }
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

            int idMesa = restaurantModel.buscarMesaLibre();
            restaurantModel.disponibilidadMesas.put(idMesa, 1);

            ClienteModel client = firstEntry.getKey();
            Cliente cliente = firstEntry.getValue();

            Integer[] posicion = restaurantModel.posicionesDeMesas.get(idMesa);

            Platform.runLater(() -> mainController.moverCliente(posicion[0], posicion[1], 2, cliente));
            client.setIdMesa(idMesa);

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
