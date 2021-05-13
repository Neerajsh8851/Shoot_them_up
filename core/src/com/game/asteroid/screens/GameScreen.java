package com.game.asteroid.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.game.asteroid.entity.Entity;
import com.game.asteroid.gameutils.SRef;


public abstract class GameScreen extends BaseScreen {

    private Stage gameHud;

    @Override
    protected void initialize() {
        super.initialize();
        gameHud = new Stage();

        // set View and camera
        SRef.activeCamera = (OrthographicCamera) getCamera();
        SRef.activeView = getViewport();

        SRef.activeView.setWorldSize(SRef.WORLD_WIDTH, SRef.VIEW_HEIGHT);
    }

    public Stage getGameHud() {
        return gameHud;
    }

    @Override
    public void show() {
        super.show();
        ((InputMultiplexer) Gdx.input.getInputProcessor()).addProcessor(getGameHud());
    }

    @Override
    public void hide() {
        super.hide();
        ((InputMultiplexer)Gdx.input.getInputProcessor()).removeProcessor(getGameHud());
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        gameHud.act(delta);
        gameHud.draw();
    }

    @Override
    public void resize(int width, int height) {
//        float vw = 400; // viewport width
//        float vh = ((float) height / width) * vw;
//        if (vh > vw) {
//            vh = vw;
//            vw = ((float) width / height ) * vh;
//        }
//
//        getViewport().setWorldSize(vw, vh);
//        System.out.println(vw + ", " + vh);
        getViewport().update(width, height);
    }


    //--------------------------
    // GETTERS
    //--------------------------
    public Camera getCamera() {
        return getMainStage().getCamera();
    }

    public Viewport getViewport() {
        return getMainStage().getViewport();
    }


    //------------------------------------
    // CAMERA ADJUSTMENT
    //------------------------------------


    public void setCameraAt(float posX, float posY) {
        getCamera().position.x = posX;
        getCamera().position.y = posY;
    }

    public void setCameraAt(Entity e) {
        setCameraAt(e.getX() + e.getOriginX(), e.getY() + e.getOriginY());
    }


    /**
     * bound the camera inside rect
     */
    private void bound(Rectangle rect) {
        Camera camera = getCamera();
        float minX = rect.x + camera.viewportWidth / 2f;
        float maxX = rect.width - camera.viewportWidth / 2f;
        camera.position.x = MathUtils.clamp(camera.position.x, minX, maxX);

        float minY = rect.y + camera.viewportHeight / 2f;
        float maxY = rect.height - camera.viewportHeight / 2f ;
        camera.position.y =  MathUtils.clamp(camera.position.y, minY, maxY);
    }
}
