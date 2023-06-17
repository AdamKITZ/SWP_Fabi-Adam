package at.fabiadam.util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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
        blocksInventory.setItem(8, ShopItems.chest);

        blocksInventory.setItem(26, ShopItems.back);

        player.openInventory(blocksInventory);
    }

    public static void openWeaponsInventory(Player player, Boolean firstOpen) {

        weaponsInventory.setItem(1, ShopItems.stick);
        weaponsInventory.setItem(2, ShopItems.diamond_sword);
        weaponsInventory.setItem(3, ShopItems.iron_sword);
        weaponsInventory.setItem(4, ShopItems.stone_sword);
        weaponsInventory.setItem(5, ShopItems.bow);
        weaponsInventory.setItem(6, ShopItems.stone_pickaxe);
        weaponsInventory.setItem(7, ShopItems.stone_axe);
        weaponsInventory.setItem(8, ShopItems.iron_pickaxe);
        weaponsInventory.setItem(9, ShopItems.golden_pickaxe);
        weaponsInventory.setItem(10, ShopItems.diamond_pickaxe);
        weaponsInventory.setItem(11, ShopItems.arrow);

        weaponsInventory.setItem(26, ShopItems.back);

        player.openInventory(weaponsInventory);
    }

    public static void openArmorInventory(Player player, Boolean firstOpen) {

        armorInventory.setItem(1, ShopItems.chainmail_chestplate);
        armorInventory.setItem(2, ShopItems.iron_chestplate);
        armorInventory.setItem(3, ShopItems.diamond_chestplate);
        armorInventory.setItem(4, ShopItems.leather_helmet);
        armorInventory.setItem(5, ShopItems.leather_chestplate);
        armorInventory.setItem(6, ShopItems.leather_leggings);
        armorInventory.setItem(7, ShopItems.leather_boots);

        armorInventory.setItem(26, ShopItems.back);

        player.openInventory(armorInventory);
    }

    public static void openSpecialInventory(Player player, Boolean firstOpen) {

        specialInventory.setItem(2, ShopItems.fire_charge);
        specialInventory.setItem(3, ShopItems.ender_pearl);
        specialInventory.setItem(4, ShopItems.snowball);
        specialInventory.setItem(6, ShopItems.healing_potion);

        specialInventory.setItem(26, ShopItems.back);

        player.openInventory(specialInventory);
    }

    public static void buyItem(Player player, ItemStack itemStack) {
        Inventory playerInventory = player.getInventory();
        String name = itemStack.getItemMeta().getDisplayName();
        String[] nameArr = name.split(" ");
        //String material = nameArr[0];
        int amount = Integer.parseInt(nameArr[0]);
        int cost = Integer.parseInt(nameArr[nameArr.length - 2]);
        String currency = nameArr[nameArr.length - 1];
        ItemStack bronze = new ItemStack(Material.BRICK);
        ItemStack iron = new ItemStack(Material.IRON_INGOT);
        ItemStack gold = new ItemStack(Material.GOLD_INGOT);

        switch(currency.toLowerCase()) {
            case "bronze":
                if(playerInventory.containsAtLeast(bronze, cost)) {
                    if(itemStack.getType() == Material.STICK) {
                        ItemStack stick = new ItemStack(Material.STICK, 1);
                        stick.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
                        ItemMeta stickMeta = stick.getItemMeta();
                        stickMeta.setDisplayName("Knockback Stick");
                        stick.setItemMeta(stickMeta);
                        player.getInventory().addItem(stick);
                        removeItems(playerInventory, bronze.getType(), cost);
                    } else if(itemStack.getType() == Material.POTION) {
                        player.getInventory().addItem(ShopItems.healing_potion);
                        removeItems(playerInventory, bronze.getType(), cost);
                    } else {
                        player.getInventory().addItem(new ItemStack(itemStack.getType(), amount));
                        removeItems(playerInventory, bronze.getType(), cost);
                    }

                }
                break;
            case "iron":
                if(playerInventory.containsAtLeast(iron, cost)) {
                    player.getInventory().addItem(new ItemStack(itemStack.getType(), amount));
                    removeItems(playerInventory, iron.getType(), cost);
                }
                break;
            case "gold":
                if(playerInventory.containsAtLeast(gold, cost)) {
                    player.getInventory().addItem(new ItemStack(itemStack.getType(), amount));
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

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
