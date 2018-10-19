package uk.ac.york.sepr4;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import lombok.Getter;
import uk.ac.york.sepr4.objects.entity.EntityManager;
import uk.ac.york.sepr4.objects.quest.QuestManager;
import uk.ac.york.sepr4.views.*;

public class PirateGame extends Game {

	public final static int MENU = 0;
	public final static int PREFERENCES = 1;
	public final static int APPLICATION = 2;
	public final static int ENDGAME = 3;

	private LoadingScreen loadingScreen;
    private PreferencesScreen preferencesScreen;
    private MenuScreen menuScreen;
    private MainScreen mainScreen;
    private EndScreen endScreen;

    private AppPreferences preferences;

    @Getter
    private EntityManager entityManager;
    @Getter
    private QuestManager questManager;
	
	@Override
	public void create () {
	    preferences = new AppPreferences();
        loadingScreen = new LoadingScreen(this);


        entityManager = new EntityManager();
        questManager =  new QuestManager(this);

        setScreen(loadingScreen);
	}

    public AppPreferences getPreferences() {
        return preferences;
    }

    public void changeScreen(int screen){
        switch(screen){
            case MENU:
                if(menuScreen == null) menuScreen = new MenuScreen(this); // added (this)
                this.setScreen(menuScreen);
                break;
            case PREFERENCES:
                if(preferencesScreen == null) preferencesScreen = new PreferencesScreen(this); // added (this)
                this.setScreen(preferencesScreen);
                break;
//            case APPLICATION:
//                if(mainScreen == null) mainScreen = new MainScreen(this); //added (this)
//                this.setScreen(mainScreen);
//                break;
//            case ENDGAME:
//                if(endScreen == null) endScreen = new EndScreen(this);  // added (this)
//                this.setScreen(endScreen);
//                break;
        }
    }
}
