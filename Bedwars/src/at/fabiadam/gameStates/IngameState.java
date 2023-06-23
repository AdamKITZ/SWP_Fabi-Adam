package at.fabiadam.gameStates;

import at.fabiadam.main.MainBedwars;
import at.fabiadam.scoreboard.Board;
import at.fabiadam.timers.EndingChecker;
import at.fabiadam.timers.SpawnerTimer;
import at.fabiadam.util.BedwarsUtil;
import at.fabiadam.util.MapReset;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class IngameState extends GameState {
    //Explained in LobbyState.java
    private BedwarsUtil util;
    private MainBedwars plugin;
    private SpawnerTimer spawnerTimer;
    private Board board;
    private MapReset mapReset;
    private EndingChecker endingChecker;

    @Override
    public void start() {
        plugin = MainBedwars.getPlugin();
        util = plugin.getUtil();
        spawnerTimer = plugin.getSpawnerTimer();
        mapReset = plugin.getMapReset();
        endingChecker = plugin.getEndingChecker();
        Bukkit.getConsoleSender().sendMessage(MainBedwars.PREFIX + "IngameState started");

        spawnerTimer.startSpawnerScheduler();
        util.start();
        util.setPlayersReady();
        util.teleportTeams();
        util.deleteItems();
        mapReset.restoreBeds();
        board = plugin.getBoard();
        endingChecker.start();
    }

    @Override
    public void stop() {
        spawnerTimer.stop();
        util.deleteItems();
        endingChecker.stop();
        Bukkit.getWorld("world_bedwars").getPlayers().forEach(player -> {
            player.getInventory().clear();
            player.getInventory().setArmorContents(null);
            player.setHealth(20);
            player.setFoodLevel(20);
            player.setExp(0);
            player.setLevel(0);
            player.setFireTicks(0);
            player.setAllowFlight(false);
            player.setFlying(false);
            player.setWalkSpeed(0.2f);
            player.setFlySpeed(0.1f);
            player.setHealthScale(20);
            player.setHealthScaled(false);
            player.setGlowing(false);
            player.getScoreboard().getObjective("test").unregister();
        });
    }
}

