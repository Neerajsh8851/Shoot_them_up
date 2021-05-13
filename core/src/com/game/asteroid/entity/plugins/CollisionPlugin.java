package com.game.asteroid.entity.plugins;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.game.asteroid.entity.Entity;


public class CollisionPlugin {


    /**
     * used to share the shape to another Entity
     */
    public interface Collision {
        public Polygon getShape();
    }

    private Polygon polygon;
    private final Entity entity;

    public CollisionPlugin(Entity entity) {
        this.entity = entity;
    }



}
