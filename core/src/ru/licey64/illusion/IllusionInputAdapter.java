package ru.licey64.illusion;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

import java.awt.event.MouseAdapter;

public class IllusionInputAdapter extends InputAdapter {

    private IllusionGame game;

    IllusionInputAdapter(IllusionGame game){
        this.game = game;
    }

    @Override
    public boolean touchDown (int x, int y, int pointer, int button) {
        if(button == Input.Buttons.LEFT) {
            game.moveFace(x, y);
        }
        return true; // return true to indicate the event was handled
    }

    @Override
    public boolean keyDown (int keycode) {
        if(keycode == Input.Keys.ESCAPE) {
            game.setPause(!game.getPause());
        }
        return true; // return true to indicate the event was handled
    }


}
