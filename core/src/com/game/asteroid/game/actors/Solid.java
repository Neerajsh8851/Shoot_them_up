package com.game.asteroid.game.actors;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.game.asteroid.entity.Entity;

public class Solid extends Entity {

    private Polygon polygon;

    public Solid(float x, float y, Stage stage) {
        super(x, y, stage);
    }


    public void createObjectShape(int n) {
        float s = 6.25f / n;

        float[] points = new float[2 * n];
        for (int i = 0; i < n; i++) {
            float x = getWidth() / 2 + getWidth() / 2 * MathUtils.cos(s * i);
            float y = getHeight() / 2 + getHeight() / 2 * MathUtils.sin(s * i);

            points[i * 2] = x;
            points[i * 2 + 1] = y;
        }

        polygon = new Polygon(points);
    }

    public Polygon getShape() {
        // sync polygon with entity
        polygon.setPosition(getX(), getY());
        polygon.setOrigin(getOriginX(), getOriginY());
        polygon.setRotation(getRotation());
        polygon.setScale(getScaleX(), getScaleY());
        return polygon;
    }


    public boolean overlap(Solid other) {
        Polygon  poly1 = getShape();
        Polygon poly2 = other.getShape();

        // preliminary check to improve performance
        if (!poly1.getBoundingRectangle().overlaps(poly2.getBoundingRectangle())) {
            return false;
        }
        return Intersector.overlapConvexPolygons(poly1, poly2);
    }

    public Vector2 preventOverlap(Solid other) {
        Polygon poly1 = this.getShape();
        Polygon poly2 = other.getShape();

        // preliminary check to improve performance
        if (!poly1.getBoundingRectangle().overlaps(poly2.getBoundingRectangle())) {
            return null;
        }

        Intersector.MinimumTranslationVector mtv = new Intersector.MinimumTranslationVector();
        if (Intersector.overlapConvexPolygons(poly1, poly2, mtv)) {
            moveBy(mtv.normal.x * mtv.depth, mtv.normal.y * mtv.depth);
        }
        return mtv.normal;
    }


}
