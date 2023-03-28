package at.fabiadam.timers;

import at.fabiadam.gameStates.EndingState;
import at.fabiadam.gameStates.GameState;
import at.fabiadam.gameStates.GameStateManager;
import at.fabiadam.main.MainBedwars;
import at.fabiadam.util.BedwarsUtil;
import at.fabiadam.util.MapReset;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class EndingChecker extends Timer {

    private MainBedwars plugin;
    private MapReset mapReset;
    private GameStateManager gameStateManager;
    private BedwarsUtil util;
    private static int taskId = 0;

    @Override
    public void start() {
        plugin = MainBedwars.getPlugin();
        util = plugin.getUtil();
        gameStateManager = plugin.getGameStateManager();

        if (taskId != 0) {
            Bukkit.getServer().broadcastMessage("tasdf");
            return;
        }

        taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(MainBedwars.getPlugin(), new Runnable() {
            int i = 20;
            @Override
            public void run() {
                util.setDeadTeams();
                if(util.getWinner() != null) {
                    Bukkit.getServer().broadcastMessage("Winner: " + util.getWinner().getTeamColor());
                    Location mainSpawn = new Location(Bukkit.getWorld("world"), 180.5, 68, -48.5);
                    util.getWinner().getPlayers().forEach(player -> {
                        player.sendTitle("§6You won!", "§a" + i + "");
                        if(i == 0) {
                            player.teleport(mainSpawn);
                            player.setScoreboard(null);
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
