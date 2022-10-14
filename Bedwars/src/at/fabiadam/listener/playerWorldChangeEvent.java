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
        lobbyTimer = MainBedwars.getLobbyTimer();
        //When player comes from spawn
            if(event.getFrom().getName().equals("world")){
                //When player goes to bedwars_lobby
                if(event.getPlayer().getWorld().getName().equals("world_bedwars_l")) {
                    playerCount = Bukkit.getWorld("world_bedwars_l").getPlayers().size();
                    checkPlayerCount();
                    Bukkit.getServer().getWorld("world_bedwars_l").getPlayers().forEach(p -> {
                        p.sendMessage(MainBedwars.PREFIX + "§a" + event.getPlayer().getName() + " joined the game!");
                        p.sendMessage(MainBedwars.PREFIX + "§a" + playerCount + "/" + maxPlayerCount + " players in the game!");
                    });
                    Bukkit.getScheduler().scheduleSyncDelayedTask(MainBedwars.getPlugin(), new Runnable() {
                        @Override
                        public void run() {
                            Player player = event.getPlayer();
                            player.getInventory().clear();
                            player.setHealth(20);
                            player.setFoodLevel(20);
                            ItemStack stick = new ItemStack(Material.STICK);
                            stick.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
                            player.getInventory().addItem(stick);
                        }
                    }, 5);
                }
            } else if(event.getFrom().getName().equals("world_bedwars_l")) {
                playerCount = Bukkit.getWorld("world_bedwars_l").getPlayers().size();
                checkPlayerCount();
                if(event.getPlayer().getWorld().getName().equals("world_bedwars")) {
                    Bukkit.getScheduler().scheduleSyncDelayedTask(MainBedwars.getPlugin(), new Runnable() {
                        @Override
                        public void run() {
                            event.getPlayer().getInventory().clear();
                        }
                    }, 5);
                }
            }
    }
    //Start the timer if there are enough players
    public void checkPlayerCount() {
        if(playerCount >= minPlayerCount) {
            lobbyTimer.startScheduler(false);
        }
    }
}
