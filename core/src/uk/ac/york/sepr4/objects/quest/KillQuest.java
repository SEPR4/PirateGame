package uk.ac.york.sepr4.objects.quest;

import lombok.Data;
import java.util.List;

@Data
public class KillQuest extends Quest {

    Integer killId;

    public KillQuest(String name, String expose, List<Quest> requires, List<Quest> gives, Reward reward, Integer killId) {
        super(name, expose, requires, gives, reward);
        this.killId = killId;
    }
}
