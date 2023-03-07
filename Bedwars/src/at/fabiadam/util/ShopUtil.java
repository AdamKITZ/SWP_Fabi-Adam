package at.fabiadam.util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

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

        blocksInventory.setItem(1, ShopItems.sandstone);
        blocksInventory.setItem(2, ShopItems.end_stone);
        blocksInventory.setItem(3, ShopItems.obsidian);
        blocksInventory.setItem(4, ShopItems.glass);
        blocksInventory.setItem(5, ShopItems.glowstone);
        blocksInventory.setItem(6, ShopItems.nether_brick);
        blocksInventory.setItem(7, ShopItems.infested_stone);

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
        String name = itemStack.getItemMeta().getDisplayName();
        String[] nameArr = name.split(" ");
        String material = nameArr[0];
        int cost = Integer.parseInt(nameArr[1]);
        String currency = nameArr[2];
        ItemStack bronze = new ItemStack(Material.BRICK);
        ItemStack iron = new ItemStack(Material.IRON_INGOT);
        ItemStack gold = new ItemStack(Material.GOLD_INGOT);

        switch(currency.toLowerCase()) {
            case "bronze":
                if(playerInventory.containsAtLeast(bronze, cost)) {
                    player.getInventory().addItem(new ItemStack(itemStack.getType()));
                    removeItems(playerInventory, bronze.getType(), cost);
                }
                break;
            case "iron":
                if(playerInventory.containsAtLeast(iron, cost)) {
                    player.getInventory().addItem(new ItemStack(itemStack.getType()));
                    removeItems(playerInventory, iron.getType(), cost);
                }
                break;
            case "gold":
                if(playerInventory.containsAtLeast(gold, cost)) {
                    player.getInventory().addItem(new ItemStack(itemStack.getType()));
                    removeItems(playerInventory, gold.getType(), cost);
                }
                break;
        }







    }

    public static int removeItems(Inventory inventory, Material type, int amount) {

        if(type == null || inventory == null)
            return -1;
        if (amount <= 0)
            return -1;

        if (amount == Integer.MAX_VALUE) {
            inventory.remove(type);
            return 0;
        }

        HashMap<Integer,ItemStack> retVal = inventory.removeItem(new ItemStack(type,amount));

        int notRemoved = 0;
        for(ItemStack item: retVal.values()) {
            notRemoved+=item.getAmount();
        }
        return notRemoved;
    }
}
