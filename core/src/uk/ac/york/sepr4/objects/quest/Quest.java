package uk.ac.york.sepr4.objects.quest;

import lombok.Data;
import java.util.List;


@Data
public abstract class Quest {

    String name;
    String expose;
    List<Quest> requires;
    List<Quest> gives;
    Reward reward;


    public Quest (String name, String expose, List<Quest> requires, List<Quest> gives, Reward reward) {
        this.name = name;
        this.expose = expose;
        this.requires = requires;
        this.gives = gives;
        this.reward = reward;
    }
}
