package com.game.asteroid.gameutils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Res {

    private static final Map<String, Object> tex = new HashMap<>();

    public static Texture loadTexture(String name, String fullName) {
        if (tex.containsKey(name)) return getTexture(name);

        Texture texture =  new Texture( Gdx.files.internal(fullName) );
        tex.put(name, texture);
        return texture;
    }

    public static Texture getTexture(String name) {
        Object obj = tex.get(name);
        return (Texture) obj;
    }


    public static void setTextureFilterToAll(Texture.TextureFilter f1, Texture.TextureFilter f2) {
        Set<String> keys =  tex.keySet();
        for (String key : keys) {
            ((Texture) tex.get(key)).setFilter(f1, f2);
        }
    }

    public static void unloadTexture(String name) {
        Texture texture = (Texture) tex.remove(name);
        texture.dispose();
    }

    public  static void unloadAllTextures() {

        String[] keys = tex.keySet().toArray(new String[0]);

        for (String key : keys) {
            ((Texture) tex.remove(key)).dispose();
            System.out.println("unloadAllTextures(): " + key);
        }
    }
}
