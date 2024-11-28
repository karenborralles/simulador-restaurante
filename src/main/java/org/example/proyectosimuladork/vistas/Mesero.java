package org.example.proyectosimuladork.vistas;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.components.TransformComponent;
import org.example.proyectosimuladork.models.MeseroModel;

import java.util.HashMap;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameWorld;

public class Mesero {
    private Entity meseroEntity;
    private HashMap<Integer, Integer[]> posicionesDeMesas = new HashMap<>();

    public Mesero(){
        // Izquierda linea 1
        this.posicionesDeMesas.put(1, new Integer[]{350, 70});
        // Izquierda linea 2
        this.posicionesDeMesas.put(2, new Integer[]{350, 200});
        // Izquierda linea 3
        this.posicionesDeMesas.put(3, new Integer[]{350, 400});
        // Derecha linea 1
        this.posicionesDeMesas.put(4, new Integer[]{600, 70});
        // Derecha linea 2
        this.posicionesDeMesas.put(5, new Integer[]{600, 200});
        // Derecha linea 3
        this.posicionesDeMesas.put(6, new Integer[]{600, 400});
    }

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

    public Integer[] getPosicionesByIdMesa(int idMesa){
        return this.posicionesDeMesas.get(idMesa);
    }
}
