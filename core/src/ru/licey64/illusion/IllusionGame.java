package ru.licey64.illusion;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector3;

public class IllusionGame extends ApplicationAdapter {
	public static final int screenWidth = 800;
	public static final int screenHeight = 480;

	private OrthographicCamera camera;
	SpriteBatch batch;

	public Character[] characters;

	private boolean pause = false;
	
	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, screenWidth, screenHeight); //инициализируем размеры игрового поля
		batch = new SpriteBatch();

		int enemyCount = 3;

		characters = new Character[enemyCount+1];

		characters[0] = new Face(this,screenWidth/2,screenHeight/2);

		for(int i = 1; i< enemyCount+1; i++){
			characters[i] = new Enemy(this, i*80, i*100);
		}

		Gdx.input.setInputProcessor(new IllusionInputAdapter(this));
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1); //цвет фона
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		for(int i = 0; i<characters.length;i++){
			characters[i].draw(batch);
		}
		batch.end();

		if(!pause) {
			for(int i = 0; i<characters.length;i++){
				characters[i].update();
			}
			for(int i = 1; i<characters.length;i++){
				if(characters[0].overlaps(characters[i])){
					gameOver();
				}
			}
		}
	}

	public void gameOver(){
		pause();
	}

	public Character getFace(){
		return characters[0];
	}

	public void moveFace(int x, int y){
		Vector3 movePos = new Vector3();
		movePos.set(x, y, 0);
		camera.unproject(movePos);
		Character face = getFace();
		face.x = movePos.x - (face.width/2);
		face.y = movePos.y - (face.height/2);
	}

	public void pause(){
		setPause(true);
	}
	public void resume(){
		setPause(false);
	}

	public void setPause(boolean pauseToSet){
		pause = pauseToSet;
	}

	public boolean getPause(){
		return pause;
	}
}
