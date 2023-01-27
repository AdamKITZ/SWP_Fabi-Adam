package at.fabiadam.gameStates;

import at.fabiadam.main.MainBedwars;

public class GameStateManager {
    //We have a GameStateManager to manage the gamestates
    //From here you can stop a gamestate and start another one

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

    public GameState getGameState() {
        return currentGameState;
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
