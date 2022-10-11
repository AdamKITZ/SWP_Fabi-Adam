package at.fabiadam.listener;

import at.fabiadam.main.MainBedwars;
import at.fabiadam.timers.LobbyTimer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.inventory.ItemStack;


public class playerWorldChangeEvent implements Listener {
    private LobbyTimer lobbyTimer;
    public static int playerCount = 0;
    public static int maxPlayerCount = 4;
    public static int minPlayerCount = 2;


    @EventHandler
    public void onWorldChangeEvent(PlayerChangedWorldEvent event) {

        lobbyTimer = LobbyTimer.getLobbyTimer();
        //Send message to all players in the world
        if(event.getPlayer().getWorld().getName().equals("world_bedwars_l") || event.getFrom().getName().equals("world_bedwars_l")) {
            playerCount = Bukkit.getServer().getWorld("world_bedwars_l").getPlayers().size();
        }
        if(event.getPlayer().getWorld().getName().equals("world_bedwars_l")) {
            Bukkit.getServer().getWorld("world_bedwars_l").getPlayers().forEach(player -> {
                player.sendMessage(MainBedwars.PREFIX + "§a" + event.getPlayer().getName() + " joined the game!");
                player.sendMessage(MainBedwars.PREFIX + "§a" + playerCount + "/" + maxPlayerCount + " players in the game!");
            });
        }
        checkPlayerCount();
        Player player = event.getPlayer();
        if(event.getPlayer().getWorld().getName().equals("world_bedwars_l") || event.getFrom().getName().equals("world_bedwars_l")) {
            ItemStack stick = new ItemStack(Material.STICK);
            stick.addEnchantment(Enchantment.KNOCKBACK, 1000);
            player.getInventory().addItem(stick);
        }
    }
    //Start the timer if there are enough players
    public void checkPlayerCount() {
        if(playerCount >= minPlayerCount) {
            lobbyTimer.startScheduler(false);
        }
    }
}
