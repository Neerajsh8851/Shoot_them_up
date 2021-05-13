package com.game.asteroid.gameutils;

import com.game.asteroid.entity.Entity;

public class GameUtils {

    public static void wrapAroundWorld(Entity e) {
        if (e.getX() + e.getWidth() < 0)
            e.setX(SRef.WORLD_WIDTH);
        if (e.getX() > SRef.WORLD_WIDTH)
            e.setX( -e.getWidth());
        if (e.getY() + e.getHeight() < 0)
            e.setY( SRef.WORLD_HEIGHT );
        if (e.getY() > SRef.WORLD_HEIGHT)
            e.setY( -e.getHeight() );
    }

    public static void setView(float viewWidth, float viewHeight) {
        SRef.VIEW_WIDTH = viewWidth;
        SRef.VIEW_HEIGHT = viewHeight;
        SRef.activeView.setWorldSize(viewWidth, viewHeight);
    }
}
