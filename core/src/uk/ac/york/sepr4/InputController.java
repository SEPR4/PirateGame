package uk.ac.york.sepr4;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import uk.ac.york.sepr4.objects.entity.Attribute;
import uk.ac.york.sepr4.objects.entity.EntityManager;
import uk.ac.york.sepr4.objects.entity.Player;

public class InputController implements InputProcessor {
    private EntityManager entityManager;

    boolean left, right, up, down = false;
    Integer noPressed = 0;

    public InputController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void movePlayer(){
        Vector2 pos = entityManager.getOrCreatePlayer().getPos();
        Vector2 dir = entityManager.getOrCreatePlayer().getDirection();

        Attribute attribute = entityManager.getOrCreatePlayer().getAttribute();

        if(left){
            dir.rotate(-5f);
        }
        if(right){
            dir.rotate(5f);
        }
        if(up){
            dir.scl(attribute.getSpeedGain()/2);
        }
        if(down){
            dir.scl(1/(attribute.getSpeedGain()/2));
        }
//        if(noPressed == 0){
//            //drag
//            dir.set(dir.x*0.8f, dir.y*0.8f);
//        }
        pos.add(dir);
        //len2 better than len (libgdx docs)
        if(dir.len2() > attribute.getMaxSpeed()){
            dir.clamp(0f, attribute.getMaxSpeed());
        }
        entityManager.getOrCreatePlayer().setDirection(dir);
        entityManager.getOrCreatePlayer().setPos(pos);
        Gdx.app.log("pos", entityManager.getOrCreatePlayer().getPos().toString());
        Gdx.app.log("dir", entityManager.getOrCreatePlayer().getDirection().toString());

    }


    @Override
    public boolean keyDown(int keycode) {
        noPressed++;
        switch(keycode){
            case Input.Keys.LEFT:
                left = true;
                break;
            case Input.Keys.RIGHT:
                right = true;
                break;
            case Input.Keys.UP:
                up = true;
                break;
            case Input.Keys.DOWN:
                down = true;
                break;

        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        noPressed--;
        switch(keycode){
            case Input.Keys.LEFT:
                left = false;
                break;
            case Input.Keys.RIGHT:
                right = false;
                break;
            case Input.Keys.UP:
                up = false;
                break;
            case Input.Keys.DOWN:
                down = false;
                break;

        }
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
