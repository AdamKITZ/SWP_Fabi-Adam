package at.fabiadam.gameStates;

import at.fabiadam.main.MainBedwars;
import at.fabiadam.scoreboard.Board;
import at.fabiadam.timers.SpawnerTimer;
import at.fabiadam.util.BedwarsUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class IngameState extends GameState {
    private BedwarsUtil util;
    private MainBedwars plugin;
    private SpawnerTimer spawnerTimer;
    private Board board;

    @Override
    public void start() {
        plugin = MainBedwars.getPlugin();
        util = plugin.getUtil();
        spawnerTimer = plugin.getSpawnerTimer();
        Bukkit.getConsoleSender().sendMessage(MainBedwars.PREFIX + "IngameState started");

        spawnerTimer.startSpawnerScheduler();
        util.start();
        util.setPlayersReady();
        util.teleportTeams();
        util.deleteItems();
        board = plugin.getBoard();
    }

    @Override
    public void stop() {

    }
}

