package at.fabiadam.listener;

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
        if(event.getPlayer().getWorld().getName().equals("world_bedwars_l")){
            if(event.getPlayer().getGameMode() == GameMode.SURVIVAL){
                if(!(event.getBlock().getType() == Material.RED_BED)) {
                    event.setCancelled(true);
                }
            }
        }
    }
}
