package at.fabiadam.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ShopItems {
    static ItemStack blocks = new ItemStack(Material.SANDSTONE);

    static ItemStack weapons = new ItemStack(Material.DIAMOND_SWORD);

    static ItemStack armor = new ItemStack(Material.DIAMOND_CHESTPLATE);

    static ItemStack special = new ItemStack(Material.FIRE_CHARGE);

    public static void renameAll() {

        blocks.getItemMeta().setDisplayName("§bBlocks");
        weapons.getItemMeta().setDisplayName("§bWeapons");
        armor.getItemMeta().setDisplayName("§bArmor");
        special.getItemMeta().setDisplayName("§bSpecial");
    }
}
