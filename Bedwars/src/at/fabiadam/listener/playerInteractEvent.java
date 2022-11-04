package at.fabiadam.listener;


import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ItemMergeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class playerInteractEvent implements Listener {

    @EventHandler
    public void onPlayerInteract (PlayerInteractEvent event){
        if(event.getPlayer().getWorld().getName().equals("world_bedwars_l")){
            if(event.getPlayer().getGameMode() == GameMode.SURVIVAL){
                event.setCancelled(true);
                if(event.getPlayer().getLocation().getY() <= 70){
                    if(!event.getPlayer().getInventory().contains(Material.STICK)) {
                        ItemStack stick = new ItemStack(Material.STICK);
                        stick.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
                        ItemMeta stickMeta = stick.getItemMeta();
                        stickMeta.setDisplayName("§6§lKnockback Stick");
                        event.getPlayer().getInventory().addItem(stick);
                    }
                }
            }
        }
        else if (event.getPlayer().getWorld().getName().equals("world_bedwars")){
            if(event.getAction() == Action.RIGHT_CLICK_BLOCK){
                if(event.getClickedBlock().getType() == Material.RED_BED){
                    event.setCancelled(true);
                }
                else if (event.getClickedBlock().getType() == Material.GREEN_BED){
                    event.setCancelled(true);
                }
                else if(event.getClickedBlock().getType() == Material.BLUE_BED){
                    event.setCancelled(true);
                }
                else if(event.getClickedBlock().getType() == Material.YELLOW_BED){
                    event.setCancelled(true);
                }
            }
        }
    }
}
