package uk.ac.york.sepr4.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import uk.ac.york.sepr4.InputController;
import uk.ac.york.sepr4.PirateGame;
import uk.ac.york.sepr4.objects.entity.EntityManager;
import uk.ac.york.sepr4.objects.entity.Player;
import uk.ac.york.sepr4.objects.quest.QuestManager;

public class GameScreen implements Screen {

    private OrthographicCamera orthographicCamera;
    private SpriteBatch spriteBatch;

    private EntityManager entityManager;
    private QuestManager questManager;

    private PirateGame pirateGame;

    private InputController inputController;

    private Texture seaBackground;

    TiledMap tiledMap;
    TiledMapRenderer tiledMapRenderer;


    public GameScreen(PirateGame pirateGame){
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        this.pirateGame = pirateGame;

        orthographicCamera = new OrthographicCamera();
        orthographicCamera.setToOrtho(false, w,h);
        orthographicCamera.update();

        tiledMap = new TmxMapLoader().load("FullSea.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap, 1);

        this.spriteBatch = new SpriteBatch();

        entityManager = new EntityManager();
        questManager = new QuestManager(entityManager);

        inputController = new InputController(entityManager);

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this.inputController);
    }

    private Vector2 getAdjustedPos(Player player){
        Vector2 vector2 = player.getPos();
        vector2.set(vector2.x-(player.getTexture().getWidth()/2), vector2.y-(player.getTexture().getHeight()/2));
        return vector2;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        orthographicCamera.position.set(entityManager.getOrCreatePlayer().getPos(),0);
        orthographicCamera.update();

        tiledMapRenderer.setView(orthographicCamera);
        tiledMapRenderer.render();

        spriteBatch.begin(); // begin rendering

       // inputController.movePlayer();
        //entityManager.getOrCreatePlayer().render(spriteBatch);

        spriteBatch.end();
    }

    @Override
    public void resize(int width, int height) {
        orthographicCamera.update();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
