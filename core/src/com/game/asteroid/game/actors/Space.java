package com.game.asteroid.game.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.game.asteroid.entity.Entity;
import com.game.asteroid.gameutils.Res;
import com.game.asteroid.gameutils.SRef;

public class Space extends Entity {

    TextureRegion texture;
    String textureName;

    public Space(Stage stage) {
        super(0, 0,  stage);
        textureName = "space";
        texture = new TextureRegion(Res.loadTexture(textureName, "space.png"));

        setSize(Res.getTexture(textureName).getWidth(), Res.getTexture(textureName).getHeight());
        setOrigin(SRef.WORLD_WIDTH/2f, SRef.WORLD_HEIGHT / 2f);
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        draw(batch, texture);
    }
}
