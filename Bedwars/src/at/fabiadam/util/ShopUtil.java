package at.fabiadam.util;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ShopUtil {
    public static final String SHOP_TITLE = "§bShop";
    public static Inventory shopInventory = Bukkit.createInventory(null, InventoryType.CHEST, SHOP_TITLE);

    public static Inventory blocksInventory = Bukkit.createInventory(null, InventoryType.CHEST, "Blocks");

    public static Inventory weaponsInventory = Bukkit.createInventory(null, InventoryType.CHEST, "Weapons");

    public static Inventory armorInventory = Bukkit.createInventory(null, InventoryType.CHEST, "Armor");

    public static Inventory specialInventory = Bukkit.createInventory(null, InventoryType.CHEST, "Special");

    public static void openShopInventory(Player player, Boolean firstOpen) {
        if (firstOpen) {
            player.playSound(player.getLocation(), Sound.ENTITY_SLIME_ATTACK, 1, 1);
        }


        shopInventory.setItem(10, ShopItems.blocks);
        shopInventory.setItem(12, ShopItems.weapons);
        shopInventory.setItem(14, ShopItems.armor);
        shopInventory.setItem(16, ShopItems.special);

        player.openInventory(shopInventory);
    }

    public static void openBlocksInventory(Player player, Boolean firstOpen) {



        blocksInventory.setItem(10, ShopItems.blocks);
        blocksInventory.setItem(12, ShopItems.weapons);
        blocksInventory.setItem(14, ShopItems.armor);
        blocksInventory.setItem(16, ShopItems.special);

        player.openInventory(blocksInventory);
    }

    public static void openWeaponsInventory(Player player, Boolean firstOpen) {



        weaponsInventory.setItem(10, ShopItems.blocks);
        weaponsInventory.setItem(12, ShopItems.weapons);
        weaponsInventory.setItem(14, ShopItems.armor);
        weaponsInventory.setItem(16, ShopItems.special);

        player.openInventory(weaponsInventory);
    }

    public static void openArmorInventory(Player player, Boolean firstOpen) {



        armorInventory.setItem(10, ShopItems.blocks);
        armorInventory.setItem(12, ShopItems.weapons);
        armorInventory.setItem(14, ShopItems.armor);
        armorInventory.setItem(16, ShopItems.special);

        player.openInventory(armorInventory);
    }

    public static void openSpecialInventory(Player player, Boolean firstOpen) {



        specialInventory.setItem(10, ShopItems.blocks);
        specialInventory.setItem(12, ShopItems.weapons);
        specialInventory.setItem(14, ShopItems.armor);
        specialInventory.setItem(16, ShopItems.special);

        player.openInventory(specialInventory);
    }

    public static void buyItem(Player player, ItemStack itemStack) {
        Inventory playerInventory = player.getInventory();
       //if(playerInventory.containsAtLeast()) {

        //}
    }
}
