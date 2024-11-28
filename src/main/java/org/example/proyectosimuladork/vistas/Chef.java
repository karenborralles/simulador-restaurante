package org.example.proyectosimuladork.vistas;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.components.TransformComponent;
import org.example.proyectosimuladork.controladores.MainController;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameWorld;

public class Chef {
    private Entity chefEntity;

    public void crearChef(double posX, double posY){
        this.chefEntity = getGameWorld().spawn("chef", posX, posY);
        TransformComponent transform = this.chefEntity.getTransformComponent();
        transform.setScaleX(0.2);
        transform.setScaleY(0.2);
    }

    public Entity getChefEntity() {
        return chefEntity;
    }
}
