package uk.ac.york.sepr4.objects.entity;

import lombok.Data;
import uk.ac.york.sepr4.objects.item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public class Player extends Entity {

    Integer balance;
    Integer xp;
    List<Item> inventory;

    public Player(Integer id, Optional<Float> locX, Optional<Float> locY) {
        super(id, 10.0, locX, locY);

        this.balance = 0;
        this.xp = 0;
        this.inventory = new ArrayList<>();

    }

    

    public Integer getLevel(){
        //level is based on xp
        //change this
        return 1;
    }
}
