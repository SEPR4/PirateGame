package uk.ac.york.sepr4.objects.entity;

import com.badlogic.gdx.math.Vector2;
import lombok.Data;
import uk.ac.york.sepr4.objects.TextureManager;
import java.util.Optional;

@Data
public class Enemy extends Entity {

    private String name;
    private Double accuracy;

    public Enemy(Integer id, Optional<String> name, Optional<Double> accuracy, Optional<Attribute> attribute, Optional<Vector2> pos, Optional<Vector2> direction) {
        super(id, TextureManager.ENEMY, attribute, pos, direction);

        if(name.isPresent()){
            this.name = name.get();
        } else {
            this.name = "Enemy Pirate";
        }
        if(accuracy.isPresent()){
            this.accuracy = accuracy.get();
        } else {
            this.accuracy = 0.75;
        }
    }

    @Override
    public void update() {
        //AI Move
    }

    @Override
    public void move() {

    }

    @Override
    public void rotate() {

    }
}
