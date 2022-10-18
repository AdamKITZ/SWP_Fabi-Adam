package at.fabiadam.gameStates;

import at.fabiadam.main.MainBedwars;
import at.fabiadam.util.BedwarsUtil;
import org.bukkit.Bukkit;

public class IngameState extends GameState {
    private BedwarsUtil util;
    private MainBedwars plugin;

    @Override
    public void start() {
        plugin = MainBedwars.getPlugin();
        util = MainBedwars.getUtil();
        Bukkit.getConsoleSender().sendMessage(MainBedwars.PREFIX + "IngameState started");
        util.start();


    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub
    }
}

