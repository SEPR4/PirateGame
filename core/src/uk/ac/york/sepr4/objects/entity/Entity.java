package uk.ac.york.sepr4.objects.entity;

import lombok.Data;

import java.util.Optional;

@Data
public class Entity {

    Integer id;
    Double health;
    Double maxHealth;

    Float locX;
    Float locY;

    public Entity(Integer id, Double maxHealth, Optional<Float> locX, Optional<Float> locY) {
        this.id = id;
        this.health = maxHealth;
        this.maxHealth = maxHealth;
        if(locX.isPresent()){
            this.locX = locX.get();
        }
        if(locY.isPresent()){
            this.locY = locY.get();
        }
    }

    public void move(){
        //...
    }

}
