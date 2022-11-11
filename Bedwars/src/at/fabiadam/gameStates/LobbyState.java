package at.fabiadam.gameStates;

import at.fabiadam.main.MainBedwars;
import at.fabiadam.util.BedwarsUtil;
import org.bukkit.Bukkit;

public class LobbyState extends GameState {
    public static final int MAX_PLAYERS = 4;
    public static final int MIN_PLAYERS = 1;
    private MainBedwars plugin;

    @Override
    public void start() {
        this.plugin = MainBedwars.getPlugin();
        Bukkit.getConsoleSender().sendMessage(plugin.PREFIX + "LobbyState started");
    }

    @Override
    public void stop() {

    }
}

