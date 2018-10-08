package uk.ac.york.sepr4.views;

import com.badlogic.gdx.Screen;
import uk.ac.york.sepr4.PirateGame;

public class LoadingScreen implements Screen {

    private PirateGame parent;

    public LoadingScreen(PirateGame pirateGame){
        parent = pirateGame;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        parent.changeScreen(PirateGame.MENU);
    }

    @Override
    public void resize(int width, int height) {

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
