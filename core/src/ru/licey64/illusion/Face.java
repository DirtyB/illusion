package ru.licey64.illusion;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by User on 28.12.2015.
 */
public class Face extends Character {

    Face(IllusionGame game, int x_center, int y_center) {
        super(game,x_center,y_center);

        image = new Texture("face.png"); //загружаем картинку

        speed = 500;

    }

    public void update(){
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) x -= speed * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) x += speed * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) y += speed * Gdx.graphics.getDeltaTime();
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) y -= speed * Gdx.graphics.getDeltaTime();


    }


}
