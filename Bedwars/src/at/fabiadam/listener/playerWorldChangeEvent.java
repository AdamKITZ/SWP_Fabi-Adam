package at.fabiadam.listener;

import at.fabiadam.main.MainBedwars;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class playerWorldChangeEvent implements Listener {
    public static int playerCount = 0;
    public static int maxPlayerCount = 4;
    public static int minPlayerCount = 2;
    private static int taskId;


    @EventHandler
    public void onWorldChangeEvent(PlayerChangedWorldEvent event) {
        playerCount = Bukkit.getServer().getWorld("world_bedwars_l").getPlayers().size();
        //Send message to all players in the world
        if(event.getPlayer().getWorld().getName().equals("world_bedwars_l")) {
            Bukkit.getServer().getWorld("world_bedwars_l").getPlayers().forEach(player -> {
                player.sendMessage("§a" + event.getPlayer().getName() + " joined the game!");
                player.sendMessage("§a" + playerCount + "/" + maxPlayerCount + " players in the game!");
            });
            event.getPlayer().sendMessage("§bPlayers required to start: " + minPlayerCount);
            event.getPlayer().sendMessage("§aYou can start a round by typing §6/start§a before the timer stops");
        }
        if(playerCount >= minPlayerCount) {
            startGame();
        }
    }

    public static void startGame() {
        Bukkit.getServer().getWorld("world_bedwars_l").getPlayers().forEach(player -> {
            player.sendTitle("§6Start in", "§a60 seconds");
        });
        //Start timer
        taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(MainBedwars.getPlugin(), new Runnable() {
            int i = 60;
            @Override
            public void run() {
                if(i <  6) {
                    Bukkit.getServer().getWorld("world_bedwars_l").getPlayers().forEach(player -> {
                        player.sendTitle("§6Start in", "§a" + i + "");
                    });
                }
                if(i <= 0) {
                    Bukkit.getScheduler().cancelTask(taskId);
                    Location bedwarsSpawn = new Location(Bukkit.getWorld("world_bedwars"), 0.5, 75, 0.5);
                    Bukkit.getServer().getWorld("world_bedwars_l").getPlayers().forEach(player -> {
                        player.teleport(bedwarsSpawn);
                    });
                }

                i--;
            }

        }, 0, 20);
    }
}
