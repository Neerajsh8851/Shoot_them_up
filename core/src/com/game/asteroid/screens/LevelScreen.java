package com.game.asteroid.screens;

import com.game.asteroid.game.actors.Space;
import com.game.asteroid.game.actors.SpaceShip;


public class LevelScreen extends GameScreen {
    SpaceShip spaceShip;
    Space space;

    @Override
    protected void initialize() {
        super.initialize();

        space = new Space(getMainStage());
        spaceShip = new SpaceShip(0, 0, getMainStage() );
    }

    @Override
    protected void update(float delta) {

    }
}
