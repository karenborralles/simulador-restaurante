package org.example.proyectosimuladork.controladores;

import org.example.proyectosimuladork.vistas.Chef;
import org.example.proyectosimuladork.vistas.Cliente;
import org.example.proyectosimuladork.vistas.Mesero;
import org.example.proyectosimuladork.vistas.Recepcionista;

public class MainController {

    public void iniciar(){
        Chef chefEntity = new Chef();
        Cliente clienteEntity = new Cliente();
        Mesero meseroEntity = new Mesero();
        Recepcionista recepcionistaEntity = new Recepcionista();

        clienteEntity.crearCliente(0, 8);
        chefEntity.crearChef(613, 40);
        meseroEntity.crearMesero(390, 210);
        recepcionistaEntity.crearRecepcionista(40, 0);
    }
}
