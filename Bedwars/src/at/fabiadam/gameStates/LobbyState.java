package at.fabiadam.gameStates;

import at.fabiadam.main.MainBedwars;
import org.bukkit.Bukkit;

public class LobbyState extends GameState {
    public static final int MAX_PLAYERS = 4;
    public static final int MIN_PLAYERS = 2;
    private MainBedwars plugin;

    @Override
    public void start() {
        this.plugin = MainBedwars.getPlugin();
        Bukkit.getConsoleSender().sendMessage(plugin.PREFIX + "LobbyState started");
    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub
    }
}
