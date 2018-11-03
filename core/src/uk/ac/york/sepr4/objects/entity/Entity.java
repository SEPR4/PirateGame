package uk.ac.york.sepr4.objects.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import lombok.Data;

import java.util.Optional;

@Data
public abstract class Entity extends Actor {

    Integer id;
    Attribute attribute;

    protected Vector2 pos, direction;
    protected Texture texture;
    protected float angle;

    public Entity(Integer id, Texture texture, Optional<Attribute> attribute, Optional<Vector2> pos, Optional<Vector2> direction) {
        this.id = id;
        this.texture = texture;

        if(pos.isPresent()){
            this.pos = pos.get();
        } else {
            this.pos = new Vector2(0,0);
        }

        if(direction.isPresent()){
            this.direction = direction.get();
        } else {
            this.direction = new Vector2(0,0);
        }

        if(attribute.isPresent()){
            this.attribute = attribute.get();
        } else {
            this.attribute = new Attribute();
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        Sprite sprite = new Sprite(texture);
        sprite.setPosition(pos.x, pos.y);
        sprite.setRotation(angle);
        sprite.draw(batch);
    }

}
