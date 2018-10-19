package uk.ac.york.sepr4.objects.entity;

import java.util.List;
import java.util.Optional;

public class BossEnemy extends Entity {

    List<Attribute> attributeList;
    //also abilities

    public BossEnemy(Integer id, Double maxHealth, Optional<Float> locX, Optional<Float> locY, List<Attribute> attributes) {
        super(id, maxHealth, locX, locY);
    }
}
