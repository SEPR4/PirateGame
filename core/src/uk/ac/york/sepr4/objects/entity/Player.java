package uk.ac.york.sepr4.objects.entity;

import com.badlogic.gdx.math.Vector2;
import lombok.Data;
import uk.ac.york.sepr4.objects.TextureManager;
import uk.ac.york.sepr4.objects.item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public class Player extends Entity {

    private Integer balance;
    Integer xp;
    List<Item> inventory;

    public Player(Integer id, Optional<Vector2> pos, Optional<Vector2> direction) {
        super(id, TextureManager.BROKEN_SHIP, Optional.empty(), pos, direction);

        this.balance = 0;
        this.xp = 0;
        this.inventory = new ArrayList<>();

    }

    public Integer getLevel(){
        //level is based on xp
        //change this
        return 1;
    }

    @Override
    public void act(float deltaTime){
        super.act(deltaTime);
    }
}
