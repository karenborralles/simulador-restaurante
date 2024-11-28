package org.example.proyectosimuladork.vistas;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.components.TransformComponent;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameWorld;

public class Mesero {
    private Entity meseroEntity;

    public void crearMesero(double posX, double posY){
        this.meseroEntity = getGameWorld().spawn("mesero", posX, posY);
        TransformComponent transform = this.meseroEntity.getTransformComponent();
        transform.setScaleX(0.5);
        transform.setScaleY(0.5);
    }

    public void moverMesero(double x, double y,  int tiempo){
        UtilidadesVistas.moverAOtraPosicion(meseroEntity, x, y, tiempo);
    }

    public Entity getMeseroEntity() {
        return meseroEntity;
    }
}
