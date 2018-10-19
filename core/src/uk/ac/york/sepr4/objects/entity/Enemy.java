package uk.ac.york.sepr4.objects.entity;

import java.util.Optional;

public class Enemy extends Entity {
    public Enemy(Integer id, Double maxHealth, Optional<Float> locX, Optional<Float> locY) {
        super(id, maxHealth, locX, locY);
    }
}
