package at.fabiadam.timers;

import at.fabiadam.main.MainBedwars;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import static at.fabiadam.listener.playerWorldChangeEvent.minPlayerCount;
import static at.fabiadam.listener.playerWorldChangeEvent.playerCount;
import static at.fabiadam.timers.spawnerTimer.startSpawnerScheduler;

public class lobbyTimer {
    private static int taskId = 0;
    private static boolean commandUsed = false;
    public static void startScheduler(boolean cmdUsed) {
        commandUsed = cmdUsed;
        //Return if the timer is already running
        if(taskId != 0) {
            return;
        }
        //Start timer and set the task id to a variable to cancel the timer later
        taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(MainBedwars.getPlugin(), new Runnable() {
            int i = 60;
            @Override
            public void run() {
                checkPlayerCount();
                //Send title to all players in the world with the current time
                if(i <  6 || i == 30 || i > 56) {
                    Bukkit.getServer().getWorld("world_bedwars_l").getPlayers().forEach(player -> {
                        player.sendTitle("§6Start in", "§a" + i + "");
                    });
                }
                //Teleport all players to the game world and reset variables
                if(i <= 0) {
                    //Reset
                    Bukkit.getScheduler().cancelTask(taskId);
                    taskId = 0;
                    commandUsed = false;
                    //Teleport players
                    Location bedwarsSpawn = new Location(Bukkit.getWorld("world_bedwars"), 0.5, 75, 0.5);
                    Bukkit.getServer().getWorld("world_bedwars_l").getPlayers().forEach(player -> {
                        player.teleport(bedwarsSpawn);
                    });
                    startSpawnerScheduler();
                }

                i--;
            }

        }, 0, 20);


    }
    //Stop the scheduler if there are not enough players and reset variables
    public static void checkPlayerCount() {
        if(playerCount < minPlayerCount) {
            if(!commandUsed) {
                Bukkit.getScheduler().cancelTask(taskId);
                taskId = 0;
                commandUsed = false;
                Bukkit.getServer().getWorld("world_bedwars_l").getPlayers().forEach(player -> {
                    player.sendMessage("§cTimer Stopped! Not enough players to start the game!");
                });
            }
        }
    }
}
