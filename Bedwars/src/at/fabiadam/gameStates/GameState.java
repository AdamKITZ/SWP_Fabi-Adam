package at.fabiadam.gameStates;

public abstract class GameState {

    public static final int LOBBY = 0;
    public static final int GAME = 1;
    public static final int END = 2;

    public abstract void start();
    public abstract void stop();
}
