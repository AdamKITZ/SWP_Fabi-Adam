package at.fabiadam.main;

import at.fabiadam.commands.setSpawner;
import at.fabiadam.commands.startLobbyTimer;
import at.fabiadam.gameStates.GameStateManager;
import at.fabiadam.gameStates.GameState;
import at.fabiadam.listener.*;
import at.fabiadam.timers.LobbyTimer;
import at.fabiadam.timers.SpawnerTimer;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MainBedwars extends JavaPlugin {

    public static final String PREFIX = "§8[§6Bedwars§8]§r ";
    private static MainBedwars plugin;
    private static LobbyTimer lobbyTimer;
    private static SpawnerTimer spawnerTimer;
    private GameStateManager gameStateManager;

    @Override
    public void onEnable() {
        plugin = this;
        System.out.println("Bedwars Plugin enabled!");

        lobbyTimer = new LobbyTimer();
        spawnerTimer = new SpawnerTimer();
        gameStateManager = new GameStateManager(this);
        gameStateManager.setGameState(GameState.LOBBY);

        //Register all created commands
        getCommand("start").setExecutor(new startLobbyTimer());
        getCommand("setspawner").setExecutor(new setSpawner());

        //Register all listeners
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new playerWorldChangeEvent(), this);
        pluginManager.registerEvents(new playerJoinEvent(), this);
        pluginManager.registerEvents(new playerInteractEvent(), this);
        pluginManager.registerEvents(new entityDamageByEntityEvent(), this);
        pluginManager.registerEvents(new playerDropEvent(), this);
    }

    public static MainBedwars getPlugin() {
        return plugin;
    }
    public static LobbyTimer getLobbyTimer() {
        return lobbyTimer;
    }
    public static SpawnerTimer getSpawnerTimer() {
        return spawnerTimer;
    }
    public GameStateManager getGameStateManager() {
        return gameStateManager;
    }
}
