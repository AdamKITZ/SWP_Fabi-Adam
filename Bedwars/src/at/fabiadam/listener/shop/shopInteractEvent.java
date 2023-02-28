package at.fabiadam.listener.shop;

import at.fabiadam.util.ShopUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class shopInteractEvent implements Listener {
    @EventHandler
    public void onShopInteract(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        if(player.getWorld().getName().equals("world_bedwars")){
            if (event.getRightClicked().getCustomName().equals("§bShop")) {
                event.setCancelled(true);
                ShopUtil.openShopInventory(player, true);
            }
        }
    }
}
