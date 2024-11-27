package org.example.proyectosimuladork;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;

public class HelloApplication extends GameApplication {
    @Override
    protected void initSettings(GameSettings gameSettings) {
        
        gameSettings.setWidth(1000);
        gameSettings.setHeight(600);
        gameSettings.setTitle("Restaurante");
    }

    public static void main(String[] args) {
        launch(args);
    }

}



