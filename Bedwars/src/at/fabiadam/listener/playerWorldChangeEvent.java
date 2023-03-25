package at.fabiadam.listener;

import at.fabiadam.gameStates.GameState;
import at.fabiadam.gameStates.GameStateManager;
import at.fabiadam.gameStates.LobbyState;
import at.fabiadam.main.MainBedwars;
import at.fabiadam.timers.LobbyCountdown;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class playerWorldChangeEvent implements Listener {
    private LobbyCountdown lobbyCountdown;
    private MainBedwars plugin;
    private GameStateManager gameStateManager;

    private LobbyState lobbyState;

    public static int playerCount = 0;

    @EventHandler
    public void onWorldChange(PlayerChangedWorldEvent event) {
        lobbyCountdown = MainBedwars.getLobbyTimer();
        //When player comes from spawn
        if (event.getFrom().getName().equals("world")) {
            //When player goes to bedwars_lobby
            if (event.getPlayer().getWorld().getName().equals("world_bedwars_l")) {
                handlePlayerJoin(event);
            }
        } else if (event.getFrom().getName().equals("world_bedwars_l")) {
            handlePlayerQuit(event);
        }
    }

    //Start the timer if there are enough players
    public void checkPlayerCount() {
        if (playerCount >= LobbyState.MIN_PLAYERS) {
            //check if timer is already running (number of players is needed)
            lobbyCountdown.start();
        } else {
            lobbyCountdown.stop();
        }
    }

    public void handlePlayerJoin(PlayerChangedWorldEvent event) {
        plugin = MainBedwars.getPlugin();
        gameStateManager = plugin.getGameStateManager();
        /*if(gameStateManager.getGameState() != lobbyState) {
            event.getPlayer().kickPlayer("§cThe game has already started!");
            return;
        }*/
        playerCount = Bukkit.getWorld("world_bedwars_l").getPlayers().size();
        if (playerCount > LobbyState.MAX_PLAYERS) {
            //if lobby is full, player will be kicked
            event.getPlayer().kickPlayer("§cThe lobby is full!");
            return;
        }
        checkPlayerCount();
        Bukkit.getServer().getWorld("world_bedwars_l").getPlayers().forEach(p -> {
            //send message to all players in lobby
            p.sendMessage(MainBedwars.PREFIX + "§a" + event.getPlayer().getName() + " joined the lobby!");
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
                ItemMeta stickMeta = stick.getItemMeta();
                stickMeta.setDisplayName("§6§lKnockback Stick");
                stick.setItemMeta(stickMeta);
                event.getPlayer().getInventory().addItem(stick);
            }
        }, 5);
    }

    public void handlePlayerQuit(PlayerChangedWorldEvent event) {
        playerCount = Bukkit.getWorld("world_bedwars_l").getPlayers().size();
        checkPlayerCount();
        if (event.getPlayer().getWorld().getName().equals("world_bedwars")) {
            Bukkit.getScheduler().scheduleSyncDelayedTask(MainBedwars.getPlugin(), new Runnable() {
                @Override
                public void run() {
                    event.getPlayer().getInventory().clear();
                }
            }, 5);
        }
    }

}
