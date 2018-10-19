package uk.ac.york.sepr4.objects.entity;

import java.util.HashMap;
import java.util.Optional;

public class EntityManager {

    Player player;
    HashMap<Integer, Entity> entityStore;

    public EntityManager() {

        entityStore = new HashMap<>();

    }

    public Integer getNextFreeEntityID(){
        return entityStore.size()+1;
    }

    public Player getOrCreatePlayer() {
        if(player == null) {
            player = new Player(0, Optional.empty(), Optional.empty());
        }
        return player;
    }

    public Enemy spawnEnemy(Double health, Optional<Float> x, Optional<Float> y) {
        Enemy en = new Enemy(getNextFreeEntityID(), health, x, y);
        entityStore.put(en.getId(), en);

        return en;
    }


}
