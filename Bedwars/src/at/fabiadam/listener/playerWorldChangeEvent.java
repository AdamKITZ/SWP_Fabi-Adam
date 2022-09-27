package at.fabiadam.listener;

import at.fabiadam.main.MainBedwars;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

import static at.fabiadam.timers.lobbyTimer.startScheduler;

public class playerWorldChangeEvent implements Listener {
    public static int playerCount = 0;
    public static int maxPlayerCount = 4;
    public static int minPlayerCount = 2;

    @EventHandler
    public void onWorldChangeEvent(PlayerChangedWorldEvent event) {
        //Send message to all players in the world
        if(event.getPlayer().getWorld().getName().equals("world_bedwars_l") || event.getFrom().getName().equals("world_bedwars_l")) {
            playerCount = Bukkit.getServer().getWorld("world_bedwars_l").getPlayers().size();
        }
        if(event.getPlayer().getWorld().getName().equals("world_bedwars_l")) {
            Bukkit.getServer().getWorld("world_bedwars_l").getPlayers().forEach(player -> {
                player.sendMessage("§a" + event.getPlayer().getName() + " joined the game!");
                player.sendMessage("§a" + playerCount + "/" + maxPlayerCount + " players in the game!");
            });
            event.getPlayer().sendMessage("§bPlayers required to start: " + minPlayerCount);
        }
        checkPlayerCount();
    }
    //Start the timer if there are enough players
    public static void checkPlayerCount() {
        if(playerCount >= minPlayerCount) {
            startScheduler(false);
        }
    }
}
