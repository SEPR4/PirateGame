package uk.ac.york.sepr4.objects.quest;

import com.badlogic.gdx.math.Vector2;
import uk.ac.york.sepr4.PirateGame;
import uk.ac.york.sepr4.objects.entity.Enemy;
import uk.ac.york.sepr4.objects.entity.EntityManager;
import uk.ac.york.sepr4.objects.item.items.Banana;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QuestManager {

    EntityManager entityManager;
    List<Quest> questList;
    List<Quest> completedQuest;

    public QuestManager(EntityManager entityManager) {
        this.entityManager = entityManager;
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

        Enemy enemy = entityManager.spawnEnemy(Optional.empty(), Optional.of(new Vector2(0,0)), Optional.empty());

        return new KillQuest( "Tutorial",  "This is the tutorial", new ArrayList<>(), new ArrayList<>(), tutReward, enemy.getId());
    }

    public void completeQuest(Quest quest) {
        completedQuest.add(quest);
    }

    public boolean canRecieveQuest(Quest quest){
        return completedQuest.contains(quest.getRequires());
    }

}
