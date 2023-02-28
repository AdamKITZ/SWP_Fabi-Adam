package at.fabiadam.listener.shop;

import at.fabiadam.util.ShopUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class shopInventoryClickEvent implements Listener {
    @EventHandler
public void onShopInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if(!player.getWorld().getName().equals("world_bedwars")) return;

        String title = "";

        try {
            title = event.getView().getTitle();
        } catch (Exception e) {
            return;
        }

        if (title.equals("§bShop")) {
            if(event.getClickedInventory() == null) return;
            if(event.getClickedInventory().getType() == InventoryType.PLAYER) return;
            if(!(event.getClick() == ClickType.LEFT)) return;
            if(!(event.getView().getTopInventory() == event.getClickedInventory())) return;
            if (event.getCurrentItem().getItemMeta().getDisplayName().equals("Blocks")) {
                //event.setCancelled(true);
                ShopUtil.openBlocksInventory(player, true);
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equals("Weapons")) {
                //event.setCancelled(true);
                ShopUtil.openBlocksInventory(player, true);
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equals("Armor")) {
                //event.setCancelled(true);
                ShopUtil.openBlocksInventory(player, true);
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equals("Special")) {
                //event.setCancelled(true);
                ShopUtil.openBlocksInventory(player, true);
            }

        }
    }
}
