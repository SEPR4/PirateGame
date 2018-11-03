package uk.ac.york.sepr4.objects.quest;

import uk.ac.york.sepr4.objects.item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Reward {

    List<Item> itemRewards;
    Integer gold;
    Integer xp;

    public Reward(Optional<List<Item>> items, Optional<Integer> gold, Optional<Integer> xp){
        if(items.isPresent()){
            this.itemRewards = items.get();
        } else {
            this.itemRewards = new ArrayList<>();
        }
        if(gold.isPresent()){
            this.gold = gold.get();
        } else {
            this.gold = 0;
        }
        if(xp.isPresent()){
            this.xp = xp.get();
        } else {
            this.xp = 0;
        }
    }

    public void addItem(Item item){
        this.itemRewards.add(item);
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

}
