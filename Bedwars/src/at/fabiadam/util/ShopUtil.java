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
        String name = itemStack.getItemMeta().getDisplayName();
        name = name.replaceAll("[a-zA-Z\\s]", "");
        double costDouble = Double.parseDouble(cost) * sellAmount;
       //if(playerInventory.containsAtLeast()) {

        //}
    }
    public static void handleSell(Material material, int sellAmount, Player player, String cost) {
        cost = cost.replaceAll("[a-zA-Z\\s]", "");
        double costDouble = Double.parseDouble(cost) * sellAmount;

        if(!checkAmount(material, player.getInventory(), sellAmount, player)) {
            player.sendMessage("§cNot able to sell! (Do you have any?)");
            return;
        }
        int notremoved = removeItems(player.getInventory(), material, sellAmount);
        if(notremoved>0) {
            player.sendMessage("§c" + notremoved + " items could not be sold");
        }
        //player.getInventory().remove(new ItemStack(material, 1));
        double currentMoney = config.getDouble("server.user." + player.getUniqueId() + ".money");
        config.set("server.user." + player.getUniqueId() + ".money",(currentMoney+costDouble)-notremoved*(costDouble/sellAmount));
        if(sellAmount == 64) {
            player.giveExp(2);
        } else if(sellAmount == 32) {
            player.giveExp(1);
        }
        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2, 2);
        data.saveNewConfig();
    }

    public static Boolean checkAmount(Material material, Inventory inventory, int amount, Player player) {
        if(inventory.contains(material, amount)) {
            return true;
        }
        player.playSound(player.getLocation(), Sound.ENTITY_ITEM_BREAK, 1, 1);
        return false;
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
