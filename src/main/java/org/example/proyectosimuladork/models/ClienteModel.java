package org.example.proyectosimuladork.models;

import javafx.application.Platform;
import org.example.proyectosimuladork.controladores.MainController;
import org.example.proyectosimuladork.vistas.Cliente;

public class ClienteModel implements Runnable {
    private MainController mainController;
    private double posicionX;
    private double posicionY;
    private boolean flag = true;
    private final RestaurantModel restaurantModel;
    private int idMesa;
    private boolean ordenPedida;
    private Cliente cliente;

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
                    System.out.println("Llamando mesero");
                    mainController.llamarMesero(idMesa, posicionX, posicionY, 2);
                    ordenPedida = true;
                }
                Thread.sleep(10000);
                System.out.println("CLiente comiendo");
                Thread.sleep(2000);
                System.out.println("Cliente dejando restaurant");

                restaurantModel.mesasOcupadas--;
                restaurantModel.disponibilidadMesas.put(idMesa, 0);
                mainController.desaparecerCliente(cliente);

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

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
