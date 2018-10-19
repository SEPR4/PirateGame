package uk.ac.york.sepr4.objects.quest;

import uk.ac.york.sepr4.PirateGame;
import uk.ac.york.sepr4.objects.entity.Enemy;
import uk.ac.york.sepr4.objects.item.items.Banana;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QuestManager {

    PirateGame pirateGame;
    List<Quest> questList;

    public QuestManager(PirateGame pirateGame) {
        this.pirateGame = pirateGame;
        questList = new ArrayList<>();
        questList.add(tutorialQuest());

    }

    public Optional<Quest> getQuestByID(Integer id){
        if(questList.get(id) != null){
            return Optional.of(questList.get(id));
        }
        return Optional.empty();
    }

    private Quest tutorialQuest(){

        Reward tutReward = RewardGenerator.generateGenericReward(1);
        tutReward.addItem(new Banana());

        Enemy enemy = pirateGame.getEntityManager().spawnEnemy(10.0, Optional.of(0f), Optional.of(0f));

        return new KillQuest( "Tutorial", null, "This is the tutorial", new ArrayList<>(), new ArrayList<>(), tutReward, enemy.getId());
    }

}
