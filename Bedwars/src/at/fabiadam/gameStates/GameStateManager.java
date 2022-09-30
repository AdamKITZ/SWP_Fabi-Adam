package at.fabiadam.gameStates;

import at.fabiadam.main.MainBedwars;

public class GameStateManager {

    private MainBedwars plugin;
    private GameState[] gameStates;
    private GameState currentGameState;

    public GameStateManager(MainBedwars plugin) {
        this.plugin = plugin;
        gameStates = new GameState[3];
        gameStates[0] = new LobbyState();
        gameStates[1] = new IngameState();
        gameStates[2] = new EndingState();
    }


    public void setGameState(int gameStateNumber) {
        if (currentGameState != null) {
            currentGameState.stop();
        }
        currentGameState = gameStates[gameStateNumber];
        currentGameState.start();
    }

    public void stopCurrentGameState() {
        if (currentGameState != null) {
            currentGameState.stop();
        }
    }

}
