package org.example.proyectosimuladork.vistas;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.components.TransformComponent;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameWorld;

public class Mesero {
    private Entity meseroEntity;

    public void crearMesero(double posX, double posY){
        this.meseroEntity = getGameWorld().spawn("mesero", posX, posY);
        TransformComponent transform = this.meseroEntity.getTransformComponent();
        transform.setScaleX(0.2);
        transform.setScaleY(0.2);
    }

    public Entity getMeseroEntity() {
        return meseroEntity;
    }
}
