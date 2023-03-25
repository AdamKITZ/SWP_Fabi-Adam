package at.fabiadam.timers;

import at.fabiadam.gameStates.EndingState;
import at.fabiadam.gameStates.GameState;
import at.fabiadam.gameStates.GameStateManager;
import at.fabiadam.main.MainBedwars;
import at.fabiadam.util.MapReset;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class EndingChecker extends Timer {

    private MainBedwars plugin;
    private MapReset mapReset;
    private GameStateManager gameStateManager;
    private static int taskId = 0;

    @Override
    public void start() {
        plugin = MainBedwars.getPlugin();
        gameStateManager = plugin.getGameStateManager();

        if (taskId != 0) {
            Bukkit.getServer().broadcastMessage("tasdf");
            return;
        }

        taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(MainBedwars.getPlugin(), new Runnable() {
            int i = 20;
            @Override
            public void run() {
                if(Bukkit.getWorld("world_bedwars").getPlayers().size() >= 2) {

                    //gameStateManager = plugin.getGameStateManager();
                    //
                    Location mainSpawn = new Location(Bukkit.getWorld("world"), 180.5, 68, -48.5);
                    Bukkit.getWorld("world_bedwars").getPlayers().forEach(player -> {
                        if(player.isDead()) {
                            player.sendTitle("§6Game Over", "§a" + i + "");
                        } else {
                            player.sendTitle("§6You won!", "§a" + i + "");
                        }
                        if(i == 0) {
                            player.teleport(mainSpawn);
                        }

                    });

                    i--;
                }
                //Teleport all players to the game world and reset variables

                if (i <= 0) {
                    //Teleport players

                    gameStateManager.setGameState(GameState.END);
                    mapReset = plugin.getMapReset();
                    mapReset.restore();
                    gameStateManager.setGameState(GameState.LOBBY);
                    //Reset
                    Bukkit.getScheduler().cancelTask(taskId);
                    taskId = 0;

                }
            }

        }, 0, 20);
    }

    @Override
    public void stop() {

    }
}
