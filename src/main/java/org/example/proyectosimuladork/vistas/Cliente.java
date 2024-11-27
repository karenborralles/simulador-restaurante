package org.example.proyectosimuladork.vistas;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.components.TransformComponent;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameWorld;

public class Cliente {
    private Entity clienteEntity;

    public void crearCliente(double posX, double posY){
        this.clienteEntity = getGameWorld().spawn("cliente", posX, posY);
        TransformComponent transform = this.clienteEntity.getTransformComponent();
        transform.setScaleX(0.15);
        transform.setScaleY(0.15);
    }

    public Entity getClienteEntity() {
        return clienteEntity;
    }
}
