package at.fabiadam.listener;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

public class playerDeathEvent implements Listener {

    @EventHandler
    public void onPlayerDeathEvent(PlayerDeathEvent event) {
        Player player = event.getEntity();
        if (player.getWorld().getName().equals("world_bedwars_l")) {
            if (player.getGameMode() == GameMode.SURVIVAL) {
                event.setKeepInventory(true);
            }
        }
    }
}
