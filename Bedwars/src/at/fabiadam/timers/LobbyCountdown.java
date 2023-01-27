package at.fabiadam.timers;

import at.fabiadam.gameStates.GameState;
import at.fabiadam.gameStates.GameStateManager;
import at.fabiadam.main.MainBedwars;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import static at.fabiadam.listener.playerWorldChangeEvent.playerCount;

public class LobbyCountdown extends Timer {
    //This is the coundown class that you see in our lobby
    //It extends the abstract class Timer
    //The Timer class has a start method that starts the timer
    private static final int LOBBY_COUNTDOWN = 20;
    private MainBedwars plugin;
    private SpawnerTimer spawnerTimer;
    private GameStateManager gameStateManager;
    private static int taskId = 0;
    private int timeLeft;

    @Override
    public void start() {
        plugin = MainBedwars.getPlugin();
        spawnerTimer = plugin.getSpawnerTimer();
        //Return if the timer is already running
        if (taskId != 0) {
            return;
        }
        //Start timer and set the task id to a variable to cancel the timer later
        taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(MainBedwars.getPlugin(), new Runnable() {
            int i = 20;

            @Override
            public void run() {
                //Send title to all players in the world with the current time
                if (i < 6 || i == 30 || i > 16) {
                    Bukkit.getServer().getWorld("world_bedwars_l").getPlayers().forEach(player -> {
                        player.sendTitle("§6Start in", "§a" + i + "");
                    });
                }
                //Teleport all players to the game world and reset variables
                if (i <= 0) {
                    //Reset
                    Bukkit.getScheduler().cancelTask(taskId);
                    taskId = 0;
                    //Teleport players
                    Location bedwarsSpawn = new Location(Bukkit.getWorld("world_bedwars"), 0.5, 75, 0.5);
                    Bukkit.getServer().getWorld("world_bedwars_l").getPlayers().forEach(player -> {
                        player.teleport(bedwarsSpawn);
                    });
                    //Set gamestate to ingame
                    gameStateManager = plugin.getGameStateManager();
                    gameStateManager.setGameState(GameState.GAME);
                }

                i--;
                timeLeft = i;
            }

        }, 0, 20);


    }

    //stop method to cancel the timer
    @Override
    public void stop() {
        Bukkit.getScheduler().cancelTask(taskId);
        taskId = 0;
    }

    //return the time left
    public int timeLeft() {
        return LOBBY_COUNTDOWN - playerCount;
    }
}
