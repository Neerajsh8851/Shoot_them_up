package com.game.asteroid.gameutils;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.Viewport;

public class SRef {
    public static Game game;

    // WORLD DIMENS
    public static final float WORLD_WIDTH = 800f;
    public static final float WORLD_HEIGHT = 600f;

    // VIEW DIMENS
    public static float VIEW_WIDTH =  800f;
    public static float VIEW_HEIGHT = 600f;

    public static OrthographicCamera activeCamera;
    public static Viewport activeView;
}
