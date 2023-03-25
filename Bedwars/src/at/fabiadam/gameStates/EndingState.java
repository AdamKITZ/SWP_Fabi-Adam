package at.fabiadam.gameStates;

import at.fabiadam.main.MainBedwars;
import at.fabiadam.scoreboard.Board;
import at.fabiadam.timers.SpawnerTimer;
import at.fabiadam.util.BedwarsUtil;
import at.fabiadam.util.MapReset;
import org.bukkit.Bukkit;

public class EndingState extends GameState {
    //Explained is LobbyState.java
    private BedwarsUtil util;
    private MainBedwars plugin;
    private MapReset mapReset;


    @Override
    public void start() {
        plugin = MainBedwars.getPlugin();
        util = plugin.getUtil();
        mapReset = plugin.getMapReset();
        Bukkit.getConsoleSender().sendMessage(MainBedwars.PREFIX + "EndingState started");
    }

    @Override
    public void stop() {
        mapReset.restore();
        // TODO Auto-generated method stub
    }
}

