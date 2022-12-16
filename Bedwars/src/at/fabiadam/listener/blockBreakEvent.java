package at.fabiadam.listener;

import at.fabiadam.main.MainBedwars;
import at.fabiadam.util.BedwarsUtil;
import com.sun.tools.javac.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class blockBreakEvent implements Listener {
    private MainBedwars plugin;
    private BedwarsUtil util;

    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent event) {
        plugin = MainBedwars.getPlugin();
        util = plugin.getUtil();
        if (event.getPlayer().getWorld().getName().equals("world_bedwars")) {
            if (event.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                if (event.getBlock().getType() == Material.RED_BED) {
                    if (util.getPlayerTeam(event.getPlayer()).getTeamColor().equals("red")) {
                        event.setCancelled(true);
                        FileConfiguration config = plugin.getConfig();
                        config.set("team.red.bed", 0);
                        util.red.setBedActive(false);
                    } else {
                        Bukkit.broadcastMessage("§c§l" + event.getPlayer().getName() + " §7destroyed the  §c§lRED §7bed!");
                    }

                } else if (event.getBlock().getType() == Material.BLUE_BED) {
                    if (util.getPlayerTeam(event.getPlayer()).getTeamColor().equals("blue")) {
                        event.setCancelled(true);
                        FileConfiguration config = plugin.getConfig();
                        config.set("team.blue.bed", 0);
                        util.blue.setBedActive(false);
                    } else {
                        Bukkit.broadcastMessage("§c§l" + event.getPlayer().getName() + " §7destroyed the  §9§lBLUE §7bed!");
                    }
                } else if (event.getBlock().getType() == Material.GREEN_BED) {
                    if (util.getPlayerTeam(event.getPlayer()).getTeamColor().equals("greeb")) {
                        event.setCancelled(true);
                        FileConfiguration config = plugin.getConfig();
                        config.set("team.green.bed", 0);
                        util.green.setBedActive(false);
                    } else {
                        Bukkit.broadcastMessage("§c§l" + event.getPlayer().getName() + " §7destroyed the  §a§lGREEN §7bed!");
                    }
                } else if (event.getBlock().getType() == Material.YELLOW_BED) {
                    if (util.getPlayerTeam(event.getPlayer()).getTeamColor().equals("yellow")) {
                        event.setCancelled(true);
                        FileConfiguration config = plugin.getConfig();
                        config.set("team.yellow.bed", 0);
                        util.yellow.setBedActive(false);
                    } else {
                        Bukkit.broadcastMessage("§c§l" + event.getPlayer().getName() + " §7destroyed the  §e§lYELLOW §7bed!");
                    }
                } else {
                    event.setCancelled(true);
                }
            }
        }
    }
}
