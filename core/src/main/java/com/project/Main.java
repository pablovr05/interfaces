package com.project;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class Main extends ApplicationAdapter {
    private Stage stage;
    private Skin skin;

    @Override
    public void create() {
        // Crear el Stage y el Skin
        stage = new Stage(new ScreenViewport());
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        Gdx.input.setInputProcessor(stage);

        // Crear una tabla para alinear elementos
        Table table = new Table();
        table.setFillParent(true); // Ocupa toda la pantalla
        table.center(); // Centra los elementos dentro de la tabla

        // Crear el Label
        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = new BitmapFont();
        Label label = new Label("Hola, això és un TextView", labelStyle);

        // Crear el Botón
        TextButton button = new TextButton("Clica'm!", skin);

        // Añadir a la tabla
        table.add(label).padBottom(20); // Añade el label con un margen inferior
        table.row(); // Nueva fila
        table.add(button).width(200).height(50); // Tamaño del botón

        // Añadir la tabla al stage
        stage.addActor(table);
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
    }
}
