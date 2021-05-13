package com.game.asteroid.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

public abstract class BaseScreen extends ScreenAdapter implements InputProcessor {
    private Stage mainStage;

    public BaseScreen() {
        initialize();
    }


    @Override
    public void show() {
        ((InputMultiplexer)Gdx.input.getInputProcessor()).addProcessor(this);
        ((InputMultiplexer)Gdx.input.getInputProcessor()).addProcessor(getMainStage());
    }

    @Override
    public void hide() {
        ((InputMultiplexer)Gdx.input.getInputProcessor()).removeProcessor(this);
        ((InputMultiplexer)Gdx.input.getInputProcessor()).removeProcessor(getMainStage());
    }

    @Override
    public void render(float delta) {
        // clear screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update(delta);

        // act and draw
        getMainStage().act();
        getMainStage().draw();
    }


    protected Stage getMainStage() {
        return  mainStage;
    }


    protected void initialize() {
        mainStage = new Stage();
    }

    abstract protected void update(float delta);


    //------------------------------------
    // METHODS INHERIT FROM InputProcessor
    //-------------------------------------


    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
