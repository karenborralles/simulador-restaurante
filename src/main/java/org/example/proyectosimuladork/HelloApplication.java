package org.example.proyectosimuladork;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import org.example.proyectosimuladork.controladores.MainController;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameScene;
import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameWorld;

public class HelloApplication extends GameApplication {
    private final MainController mainController = new MainController();
    @Override
    protected void initSettings(GameSettings gameSettings) {
        gameSettings.setWidth(1000);
        gameSettings.setHeight(600);
        gameSettings.setTitle("Restaurante");
    }

    @Override
    protected void initGame() {
        getGameWorld().addEntityFactory(new MainEntityFactory());
        getGameScene().setBackgroundRepeat("fondo.jpg");
        mainController.iniciar();
    }

    public static void main(String[] args) {
        launch(args);
    }

}



