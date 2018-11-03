package uk.ac.york.sepr4;

import com.badlogic.gdx.Game;
import lombok.Getter;
import lombok.Setter;
import uk.ac.york.sepr4.views.*;

public class PirateGame extends Game {

	private LoadingScreen loadingScreen;
    private PreferencesScreen preferencesScreen;
    private MenuScreen menuScreen;
    private GameScreen gameScreen;
    private EndScreen endScreen;

    @Getter
    private AppPreferences preferences;
	
	@Override
	public void create () {
	    preferences = new AppPreferences();
        loadingScreen = new LoadingScreen(this);

        setScreen(loadingScreen);
	}

    public void switchScreen(ScreenType screenType){
        switch(screenType){
            case MENU:
                if(menuScreen == null) menuScreen = new MenuScreen(this); // added (this)
                this.setScreen(menuScreen);
                break;
            case PREFERENCES:
                if(preferencesScreen == null) preferencesScreen = new PreferencesScreen(this); // added (this)
                this.setScreen(preferencesScreen);
                break;
            case GAME:
                if(gameScreen == null) gameScreen = new GameScreen(this); //added (this)
                this.setScreen(gameScreen);
                break;
            case END:
                if(endScreen == null) endScreen = new EndScreen();  // added (this)
                this.setScreen(endScreen);
                break;
        }
    }
}
