package at.fabiadam.timers;

import at.fabiadam.gameStates.EndingState;
import at.fabiadam.gameStates.GameState;
import at.fabiadam.gameStates.GameStateManager;
import at.fabiadam.main.MainBedwars;
import at.fabiadam.util.BedwarsUtil;
import at.fabiadam.util.MapReset;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

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


        taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(MainBedwars.getPlugin(), new Runnable() {
            int i = 20;
            @Override
            public void run() {
                util.setDeadTeams();
                if(util.getWinner() != null) {
                    if(i == 19) {
                        Bukkit.getServer().broadcastMessage("Winner: " + util.getWinner().getTeamColor());
                    }
                    Location mainSpawn = new Location(Bukkit.getWorld("world"), 180.5, 68, -48.5);
                    util.getWinner().getPlayers().forEach(player -> {
                        player.sendTitle("§6You won!", "§a" + i + "");
                        if(i == 1) {
                            i = 0;
                            player.teleport(mainSpawn);
                            ScoreboardManager manager = Bukkit.getScoreboardManager();
                            player.setScoreboard(manager.getNewScoreboard());

                        }
                    });
                    if (i <= 0) {
                        //Teleport players
                        util.teamList.forEach(team -> {
                            team.getPlayers().forEach(player -> {
                                player.teleport(mainSpawn);
                                player.setGameMode(GameMode.SURVIVAL);
                                ScoreboardManager manager = Bukkit.getScoreboardManager();
                                player.setScoreboard(manager.getNewScoreboard());
                            });

                        });

                        gameStateManager.setGameState(GameState.END);
                        mapReset = plugin.getMapReset();
                        mapReset.restore();
                        gameStateManager.setGameState(GameState.LOBBY);
                        //Reset
                        Bukkit.getScheduler().cancelTask(taskId);
                        taskId = 0;

                    }


                    if(i != 0) {
                        i--;
                    }

                }
                //Teleport all players to the game world and reset variables


            }

        }, 0, 20);
    }

    @Override
    public void stop() {

    }


}
