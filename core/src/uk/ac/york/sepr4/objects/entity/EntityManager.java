package uk.ac.york.sepr4.objects.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class EntityManager {

    Player player;
    List<Entity> entityStore;

    public EntityManager() {

        entityStore = new ArrayList<>();

    }

    public Integer getNextFreeEntityID(){
        return entityStore.size()+1;
    }

    public Player getOrCreatePlayer() {
        if(player == null) {
            player = new Player(0, Optional.of(new Vector2(-50, -50)), Optional.empty());
        }
        return player;
    }

    public Enemy spawnEnemy(Optional<Attribute> attr, Optional<Vector2> pos, Optional<Vector2> direction) {
        Enemy en = new Enemy(getNextFreeEntityID(), Optional.empty(), Optional.empty(), attr, pos, direction);
        entityStore.add(en);

        return en;
    }


}
