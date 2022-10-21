package at.fabiadam.gameStates;

import at.fabiadam.main.MainBedwars;
import at.fabiadam.timers.SpawnerTimer;
import at.fabiadam.util.BedwarsUtil;
import org.bukkit.Bukkit;

public class IngameState extends GameState {
    private BedwarsUtil util;
    private MainBedwars plugin;
    private SpawnerTimer spawnerTimer;

    @Override
    public void start() {
        plugin = MainBedwars.getPlugin();
        util = plugin.getUtil();
        spawnerTimer = plugin.getSpawnerTimer();
        Bukkit.getConsoleSender().sendMessage(MainBedwars.PREFIX + "IngameState started");

        spawnerTimer.startSpawnerScheduler();
        util.start();
        util.teleportTeams();
    }

    @Override
    public void stop() {

    }
}

