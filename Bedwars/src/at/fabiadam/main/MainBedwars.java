package at.fabiadam.main;

import at.fabiadam.commands.Commands;
import at.fabiadam.commands.startLobbyTimer;
import at.fabiadam.gameStates.GameStateManager;
import at.fabiadam.gameStates.GameState;
import at.fabiadam.listener.*;
import at.fabiadam.scoreboard.Board;
import at.fabiadam.timers.LobbyCountdown;
import at.fabiadam.timers.SpawnerTimer;
import at.fabiadam.util.BedwarsUtil;
import at.fabiadam.util.MapReset;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MainBedwars extends JavaPlugin {
    //Main class of the plugin
    //We have many private classes that we need to access from other classes
    //It was best to put all of them here, then you just need to imprt the Main class and get the other classes from there
    public static final String PREFIX = "§8[§6Bedwars§8]§r ";
    private static MainBedwars plugin;
    private static LobbyCountdown lobbyCountdown;
    private SpawnerTimer spawnerTimer;
    private GameStateManager gameStateManager;
    private BedwarsUtil util;
    private Board board;
    private MapReset mapReset;


    //First starting method
    //We register all the listeners and commands here
    //Also we create the objects and start the LobbyState
    @Override
    public void onEnable() {
        plugin = this;
        Bukkit.getConsoleSender().sendMessage(PREFIX + "Plugin enabled");

        lobbyCountdown = new LobbyCountdown();
        spawnerTimer = new SpawnerTimer();
        gameStateManager = new GameStateManager(this);
        gameStateManager.setGameState(GameState.LOBBY);
        util = new BedwarsUtil();
        board = new Board();
        mapReset = new MapReset();

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
        pluginManager.registerEvents(new blockBreakEvent(), this);
        pluginManager.registerEvents(new onPlayerDeath(), this);
        pluginManager.registerEvents(new blockPlaceEvent(), this);
        pluginManager.registerEvents(new playerMoveEvent(), this);
        pluginManager.registerEvents(new entityDamageByBlockEvent(), this);
        pluginManager.registerEvents(new entityDamageEvent(), this);
        pluginManager.registerEvents(new MapReset(), this);
    }



    //Those are basically just getters
    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(PREFIX + "Plugin disabled");
        mapReset.restore();
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

    public BedwarsUtil getUtil() {
        return util;
    }

    public GameStateManager getGameStateManager() {
        return gameStateManager;
    }

    public Board getBoard() {
        return board;
    }

    public MapReset getMapReset() { return mapReset; }
}
