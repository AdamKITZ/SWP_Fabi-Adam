package at.fabiadam.listener;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class blockBreakEvent implements Listener {

    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent event) {
        if(event.getPlayer().getWorld().getName().equals("world_bedwars")){
            if(event.getPlayer().getGameMode() == GameMode.SURVIVAL){
                if(event.getBlock().getType() == Material.RED_BED){
                    Bukkit.broadcastMessage("§c§l" + event.getPlayer().getName() + " §7hat das Bett zerstört!");
                }
                else if(event.getBlock().getType() == Material.BLUE_BED){
                    Bukkit.broadcastMessage("§c§l" + event.getPlayer().getName() + " §7hat das Bett zerstört!");
                }
                else if(event.getBlock().getType() == Material.GREEN_BED){
                    Bukkit.broadcastMessage("§c§l" + event.getPlayer().getName() + " §7hat das Bett zerstört!");
                }
                else if(event.getBlock().getType() == Material.YELLOW_BED) {
                    Bukkit.broadcastMessage("§c§l" + event.getPlayer().getName() + " §7hat das Bett zerstört!");
                } else {
                    event.setCancelled(true);
                }
            }
        }
    }
}
