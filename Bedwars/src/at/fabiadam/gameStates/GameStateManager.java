package at.fabiadam.gameStates;

import at.fabiadam.main.MainBedwars;
import com.sun.tools.javac.Main;

public class GameStateManager {

    private MainBedwars plugin;
    private gameStates[] currentState;
    private gameStates currentGameState;

    public GameStateManager(MainBedwars plugin) {
        this.plugin = plugin;
        currentState = new gameStates[3];
        currentState[0] = new lobbyState();
        currentState[1] = new ingameState();
        currentState[2] = new endingState();
    }


    public void setGameState(int gameState) {
        if (currentGameState != null) {
            currentGameState.stop();
        }
        currentGameState = currentState[gameState];
        currentGameState.start();
    }

    public void stopCurrentGameState() {
        if (currentGameState != null) {
            currentGameState.stop();
        }
    }

}
