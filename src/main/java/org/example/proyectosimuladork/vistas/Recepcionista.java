package org.example.proyectosimuladork.vistas;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.components.TransformComponent;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameWorld;

public class Recepcionista {
    private Entity recepcionistaEntity;

    public void crearRecepcionista(double posX, double posY){
        this.recepcionistaEntity = getGameWorld().spawn("recepcionista", posX, posY);
        TransformComponent transform = this.recepcionistaEntity.getTransformComponent();
        transform.setScaleX(0.15);
        transform.setScaleY(0.15);
    }

    public Entity getRecepcionistaEntity() {
        return recepcionistaEntity;
    }
}
