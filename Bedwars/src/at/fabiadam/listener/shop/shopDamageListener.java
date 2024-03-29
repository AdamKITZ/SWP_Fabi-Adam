package at.fabiadam.listener.shop;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class shopDamageListener implements Listener {
    @EventHandler
    public void shopDamage(EntityDamageByEntityEvent event) {
        if(!(event.getEntity() instanceof Villager shop)) return;
        try {
            if(shop.getCustomName().equals("§bShop")) {
                event.setCancelled(true);
            }
        } catch (Exception ignored) {
            return;
        }
        if(!(event.getDamager() instanceof Player player)) return;
        event.setCancelled(true);
        if(player.getItemInHand().getType() == Material.BARRIER) {
            shop.setHealth(0);
            player.sendMessage("§cShop got deleted!");
        }
    }
}