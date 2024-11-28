package org.example.proyectosimuladork.vistas;

import com.almasb.fxgl.entity.Entity;
import javafx.animation.Interpolator;
import javafx.geometry.Point2D;
import javafx.util.Duration;

import static com.almasb.fxgl.dsl.FXGLForKtKt.animationBuilder;

public class UtilidadesVistas {
    public static void moverAOtraPosicion(Entity entidad, double x, double y, int tiempo) {
        Point2D nuevaPosicion = new Point2D(x, y);
        animationBuilder()
                .duration(Duration.seconds(tiempo))
                .interpolator(Interpolator.LINEAR)
                .translate(entidad)
                .to(nuevaPosicion)
                .buildAndPlay();
    }
}
