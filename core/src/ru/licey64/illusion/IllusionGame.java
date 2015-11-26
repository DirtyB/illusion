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

	private Rectangle face;
	private int faceSpeed;
	Texture faceImage;
	
	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, screenWidth, screenHeight); //инициализируем размеры игрового поля
		batch = new SpriteBatch();

		face = new Rectangle();
		face.width = 64;
		face.height = 64;
		face.x = (screenWidth-face.width)/2;
		face.y = (screenHeight-face.height)/2;
		faceSpeed = 500;

		faceImage = new Texture("core/assets/face.png"); //загружаем картинку

		Gdx.input.setInputProcessor(new IllusionInputAdapter(this));
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1); //цвет фона
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(faceImage, face.x, face.y); //рисуем рожицу
		batch.end();

		if(Gdx.input.isKeyPressed(Keys.LEFT)) face.x -= faceSpeed * Gdx.graphics.getDeltaTime();
		if(Gdx.input.isKeyPressed(Keys.RIGHT)) face.x += faceSpeed * Gdx.graphics.getDeltaTime();
		if(Gdx.input.isKeyPressed(Keys.UP)) face.y += faceSpeed * Gdx.graphics.getDeltaTime();
		if(Gdx.input.isKeyPressed(Keys.DOWN)) face.y -= faceSpeed * Gdx.graphics.getDeltaTime();
	}

	public void moveFace(int x, int y){
		Vector3 movePos = new Vector3();
		movePos.set(x, y, 0);
		camera.unproject(movePos);
		face.x = movePos.x - (face.width/2);
		face.y = movePos.y - (face.height/2);
	}
}
