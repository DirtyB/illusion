package ru.licey64.illusion;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by User on 28.12.2015.
 */
abstract public class Character extends Rectangle {

    protected IllusionGame game;

    protected int speed;
    protected Texture image;

    Character(IllusionGame game, int x_center, int y_center){
        super();

        this.game = game;

        width = 64;
        height = 64;

        this.x = x_center - width / 2;
        this.y = y_center - height / 2;
    }

    public void draw(SpriteBatch batch){
        batch.draw(image, x, y); //рисуем рожицу
    }

    abstract public void update();

}
