package at.fabiadam.listener.shop;

import at.fabiadam.util.ShopUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
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


        //Logic for tho main page of the shop
        if (title.equals("§bShop")) {
            event.setCancelled(true);

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
                ShopUtil.openWeaponsInventory(player, true);
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equals("Armor")) {
                //event.setCancelled(true);
                ShopUtil.openArmorInventory(player, true);
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equals("Special")) {
                //event.setCancelled(true);
                ShopUtil.openSpecialInventory(player, true);
            }
        } else if(title.equals("Blocks") || title.equals("Weapons") || title.equals("Armor") || title.equals("Special")) {
            event.setCancelled(true);

            if(event.getClickedInventory() == null) return;
            if(event.getClickedInventory().getType() == InventoryType.PLAYER) return;
            if(!(event.getClick() == ClickType.LEFT)) return;
            if(!(event.getView().getTopInventory() == event.getClickedInventory())) return;
            if(event.getCurrentItem() == null) return;
            if(event.getCurrentItem().getType() == Material.RED_DYE) {
                ShopUtil.openShopInventory(player, false);
                return;
            }
            ShopUtil.buyItem(player, event.getCurrentItem());
        }
    }
}
