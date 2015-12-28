package ru.licey64.illusion;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by User on 28.12.2015.
 */
public class Enemy extends Character {

    Enemy(IllusionGame game, int x_center, int y_center) {
        super(game,x_center,y_center);

        image = new Texture("core/assets/enemy.png"); //загружаем картинку

        speed = 300;
    }

    public void update(){
        Character face = game.getFace();
        long deltaX = Math.abs((long)(x - face.x));
        long deltaY = Math.abs((long)(y - face.y));
        if(deltaX > deltaY) {
            x += Math.signum(face.x - x) * speed * Gdx.graphics.getDeltaTime();
        }
        else{
            y += Math.signum(face.y - y) * speed * Gdx.graphics.getDeltaTime();
        }
    }


}
