package com.game.asteroid.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.game.asteroid.entity.plugins.PhysicsPlugin;
import com.game.asteroid.gameutils.GameUtils;
import com.game.asteroid.gameutils.Res;

public class SpaceShip extends Solid {
    TextureRegion texture;
    String textureName;
    PhysicsPlugin phy;


    public SpaceShip(float x, float y, Stage stage) {
        // bottom left position
        super(x, y, stage);

        textureName = "spaceship";
        texture = new TextureRegion(Res.loadTexture(textureName, "spaceship.png"));


        // set dimensions of the ship
        setSize(Res.getTexture(textureName).getWidth(), Res.getTexture(textureName).getWidth());
        setOrigin( getWidth() / 2f, getHeight() / 2f);

        phy = new PhysicsPlugin(this);
        phy.setAcceleration(200f);
        phy.setDeceleration(10f);
        phy.setMaxSpeed(100f);

        createObjectShape(8);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        draw(batch, texture);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        float rotationSpeed = 120;

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            phy.accelerateAtAngle(getRotation());
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            rotateBy(rotationSpeed * delta);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            rotateBy(-rotationSpeed * delta);
        }

        phy.applyPhysics(delta);
        GameUtils.wrapAroundWorld(this);
    }

}
