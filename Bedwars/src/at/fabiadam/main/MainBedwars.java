package at.fabiadam.main;

import at.fabiadam.commands.Commands;
import at.fabiadam.commands.startLobbyTimer;
import at.fabiadam.gameStates.GameStateManager;
import at.fabiadam.gameStates.GameState;
import at.fabiadam.listener.*;
import at.fabiadam.timers.LobbyCountdown;
import at.fabiadam.timers.SpawnerTimer;
import at.fabiadam.util.BedwarsUtil;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MainBedwars extends JavaPlugin {

    public static final String PREFIX = "§8[§6Bedwars§8]§r ";
    private static MainBedwars plugin;
    private static LobbyCountdown lobbyCountdown;
    private SpawnerTimer spawnerTimer;
    private GameStateManager gameStateManager;
    private BedwarsUtil util;

    @Override
    public void onEnable() {
        plugin = this;
        Bukkit.getConsoleSender().sendMessage(PREFIX + "Plugin enabled");

        lobbyCountdown = new LobbyCountdown();
        spawnerTimer = new SpawnerTimer();
        gameStateManager = new GameStateManager(this);
        gameStateManager.setGameState(GameState.LOBBY);
        util = new BedwarsUtil();

        //Register all created commands
        getCommand("start").setExecutor(new startLobbyTimer());
        getCommand("bw").setExecutor(new Commands());

        //Register all listeners
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new playerWorldChangeEvent(), this);
        pluginManager.registerEvents(new playerJoinEvent(), this);
        pluginManager.registerEvents(new playerInteractEvent(), this);
        pluginManager.registerEvents(new entityDamageByEntityEvent(), this);
        pluginManager.registerEvents(new playerDropEvent(), this);
        pluginManager.registerEvents(new playerDeathEvent(), this);
        pluginManager.registerEvents(new blockBreakEvent(), this);
    }
    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(PREFIX + "Plugin disabled");
    }

    public static MainBedwars getPlugin() {
        return plugin;
    }
    public static LobbyCountdown getLobbyTimer() {
        return lobbyCountdown;
    }
    public SpawnerTimer getSpawnerTimer() {
        return spawnerTimer;
    }
    public BedwarsUtil getUtil() { return util; }
    public GameStateManager getGameStateManager() {
        return gameStateManager;
    }
}
