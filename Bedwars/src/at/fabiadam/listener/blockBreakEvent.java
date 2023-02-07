package at.fabiadam.listener;

import at.fabiadam.main.MainBedwars;
import at.fabiadam.scoreboard.Board;
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
import org.bukkit.scoreboard.Scoreboard;

public class blockBreakEvent implements Listener {
    private MainBedwars plugin;
    private BedwarsUtil util;
    private Board board;

    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent event) {
        plugin = MainBedwars.getPlugin();
        util = plugin.getUtil();
        board = plugin.getBoard();
        //checks if the player is in the bedwars world
        if (event.getPlayer().getWorld().getName().equals("world_bedwars")) {
            //checks if the player is in survival mode
            if (event.getPlayer().getGameMode() == GameMode.SURVIVAL) {
                //Items can not be dropped anymore
                event.setDropItems(false);

                if (!(plugin.getDestroyableMaterials().contains(event.getBlock().getType()))) {
                    event.setCancelled(true);
                }
                //checks if the destroyed material is a (team color) bed
                if (event.getBlock().getType() == Material.RED_BED) {
                    if (util.getPlayerTeam(event.getPlayer()).getTeamColor().equals("red")) {
                        //if the player is in the same team as the bed, the event will be cancelled
                        event.setCancelled(true);
                    } else {
                        //if the player is in a different team as the bed, the bed will be destroyed and the scoreboard will be updated
                        Bukkit.broadcastMessage("§c§l" + event.getPlayer().getName() + " §7destroyed the  §c§lRED §7bed!");
                        util.red.setBedActive(false);
                        board.updateScoreboard();
                    }

                } else if (event.getBlock().getType() == Material.BLUE_BED) {
                    if (util.getPlayerTeam(event.getPlayer()).getTeamColor().equals("blue")) {
                        event.setCancelled(true);
                    } else {
                        Bukkit.broadcastMessage("§c§l" + event.getPlayer().getName() + " §7destroyed the  §9§lBLUE §7bed!");
                        util.blue.setBedActive(false);
                        board.updateScoreboard();
                    }
                } else if (event.getBlock().getType() == Material.GREEN_BED) {
                    if (util.getPlayerTeam(event.getPlayer()).getTeamColor().equals("green")) {
                        event.setCancelled(true);
                    } else {
                        Bukkit.broadcastMessage("§c§l" + event.getPlayer().getName() + " §7destroyed the  §a§lGREEN §7bed!");
                        util.green.setBedActive(false);
                        board.updateScoreboard();
                    }
                } else if (event.getBlock().getType() == Material.YELLOW_BED) {
                    if (util.getPlayerTeam(event.getPlayer()).getTeamColor().equals("yellow")) {
                        event.setCancelled(true);
                    } else {
                        Bukkit.broadcastMessage("§c§l" + event.getPlayer().getName() + " §7destroyed the  §e§lYELLOW §7bed!");
                        util.yellow.setBedActive(false);
                        board.updateScoreboard();
                    }
                } else {
                    event.setCancelled(true);
                }
            }
        }
    }
}
