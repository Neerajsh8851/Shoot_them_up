package com.game.asteroid.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.game.asteroid.gameutils.SRef;
import com.game.asteroid.gameutils.Res;
import com.game.asteroid.screens.LevelScreen;

public class AsteroidMain extends Game {
    @Override
    public void create() {
        SRef.game = this;

        // add the input multiplexer
        Gdx.input.setInputProcessor(new InputMultiplexer());

        // set welcome screen
        setScreen(new LevelScreen());
    }

    @Override
    public void dispose() {
        super.dispose();
        // clear all the resources
        Res.unloadAllTextures();
    }
}
