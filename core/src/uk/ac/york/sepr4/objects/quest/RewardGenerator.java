package uk.ac.york.sepr4.objects.quest;

import java.util.Optional;
import java.util.Random;

public class RewardGenerator {

    public static Reward generateGenericReward(Integer modifier){
        Random rand = new Random();
        Integer xp = rand.nextInt(100)*modifier;
        Integer gold = rand.nextInt(50)*modifier;
        return new Reward(Optional.empty(), Optional.of(gold), Optional.of(xp));
    }

}
