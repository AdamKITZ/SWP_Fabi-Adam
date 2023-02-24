package at.fabiadam.gameStates;

import at.fabiadam.main.MainBedwars;
import at.fabiadam.util.BedwarsUtil;
import org.bukkit.Bukkit;

public class LobbyState extends GameState {
    //So we have a LobbyState class that extends the abstract class GameState
    //Our GameState classes will have a start and stop method
    //The start method will be called when the gamestate starts and will hande everything that needs to be done
    //The lobby state does not do anything speacial, but you may find more interesting stuff in "IngameState.java"
    public static final int MAX_PLAYERS = 4;
    public static final int MIN_PLAYERS = 1;
    private MainBedwars plugin;


    @Override
    public void start() {
        this.plugin = MainBedwars.getPlugin();
        Bukkit.getConsoleSender().sendMessage(MainBedwars.PREFIX + "LobbyState started");
    }

    @Override
    public void stop() {

    }
}

