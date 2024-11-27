package org.example.proyectosimuladork;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;

import static com.almasb.fxgl.dsl.FXGLForKtKt.entityBuilder;

public class MainEntityFactory implements EntityFactory {
    @Spawns("recepcionista")
    public Entity nuevaRecepcionista(SpawnData data) {
        return entityBuilder(data)
                .at(data.getX(), data.getY())
                .viewWithBBox("recepcionista.png")
                .build();
    }

    @Spawns("chef")
    public Entity nuevoChef(SpawnData data) {
        return entityBuilder(data)
                .at(data.getX(), data.getY())
                .viewWithBBox("chef.png")
                .build();
    }

    @Spawns("cliente")
    public Entity nuevoCliente(SpawnData data) {
        return entityBuilder(data)
                .at(data.getX(), data.getY())
                .viewWithBBox("cliente.png")
                .build();
    }

    @Spawns("mesero")
    public Entity nuevoMesero(SpawnData data) {
        return entityBuilder(data)
                .at(data.getX(), data.getY())
                .viewWithBBox("mesero.png")
                .build();
    }
}
