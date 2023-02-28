package at.fabiadam.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ShopItems {
    static ItemStack blocks = new ItemStack(Material.SANDSTONE);

    static ItemStack weapons = new ItemStack(Material.DIAMOND_SWORD);

    static ItemStack armor = new ItemStack(Material.DIAMOND_CHESTPLATE);

    static ItemStack special = new ItemStack(Material.FIRE_CHARGE);

    public static void renameAll() {
        ItemMeta blocksMeta = blocks.getItemMeta();
        ItemMeta weaponsMeta = weapons.getItemMeta();
        ItemMeta armorMeta = armor.getItemMeta();
        ItemMeta specialMeta = special.getItemMeta();
        blocksMeta.setDisplayName("§bBlocks");
        weaponsMeta.setDisplayName("§bWeapons");
        armorMeta.setDisplayName("§bArmor");
        specialMeta.setDisplayName("§bSpecial");
        blocks.setItemMeta(blocksMeta);
        weapons.setItemMeta(weaponsMeta);
        armor.setItemMeta(armorMeta);
        special.setItemMeta(specialMeta);

    }
}
