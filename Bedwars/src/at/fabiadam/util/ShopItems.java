package at.fabiadam.util;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ShopItems {
    //Main Menu
    static ItemStack blocks = new ItemStack(Material.SANDSTONE);
    static ItemStack weapons = new ItemStack(Material.DIAMOND_SWORD);
    static ItemStack armor = new ItemStack(Material.DIAMOND_CHESTPLATE);
    static ItemStack special = new ItemStack(Material.FIRE_CHARGE);

    //Blocks Menu
    static ItemStack sandstone = new ItemStack(Material.SANDSTONE);
    static ItemStack end_stone = new ItemStack(Material.END_STONE);
    static ItemStack obsidian = new ItemStack(Material.OBSIDIAN);
    static ItemStack glass = new ItemStack(Material.GLASS);
    static ItemStack glowstone = new ItemStack(Material.GLOWSTONE);
    static ItemStack nether_brick = new ItemStack(Material.PACKED_ICE);
    static ItemStack infested_stone = new ItemStack(Material.INFESTED_STONE);

    //Weapons menu
    static ItemStack stick = new ItemStack(Material.STICK);
    static ItemStack diamond_sword = new ItemStack(Material.DIAMOND_SWORD);

    //Armor menu


    //Special menu

    public static void renameAll() {
        //Main menu
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

        //Blocks menu
        ItemMeta sandstoneMeta = sandstone.getItemMeta();
        ItemMeta end_stoneMeta = end_stone.getItemMeta();
        ItemMeta obsidianMeta = obsidian.getItemMeta();
        ItemMeta glassMeta = glass.getItemMeta();
        ItemMeta glowstoneMeta = glowstone.getItemMeta();
        ItemMeta nether_brickMeta = nether_brick.getItemMeta();
        ItemMeta infested_stoneMeta = infested_stone.getItemMeta();
        sandstoneMeta.setDisplayName("§bSandstone 1 Bronze");
        end_stoneMeta.setDisplayName("§bEnd Stone 6 Bronze");
        obsidianMeta.setDisplayName("§bObsidian 4 Gold");
        glassMeta.setDisplayName("§bGlass 2 Bronze");
        glowstoneMeta.setDisplayName("§bGlowstone 2 Bronze");
        nether_brickMeta.setDisplayName("§bNether Brick 2 Bronze");
        infested_stoneMeta.setDisplayName("§bInfested Stone 24 Bronze");
        sandstone.setItemMeta(sandstoneMeta);
        end_stone.setItemMeta(end_stoneMeta);
        obsidian.setItemMeta(obsidianMeta);
        glass.setItemMeta(glassMeta);
        glowstone.setItemMeta(glowstoneMeta);
        nether_brick.setItemMeta(nether_brickMeta);
        infested_stone.setItemMeta(infested_stoneMeta);

        //Weapons menu

        //Knockbackstick
        ItemMeta stickMeta = stick.getItemMeta();
        stick.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
        ItemMeta stickNewMeta = stick.getItemMeta();
        stickNewMeta.setDisplayName("§6§lKnockback Stick");
        stick.setItemMeta(stickNewMeta);

        //ItemMeta stone_swordMeta = stone_sword.getItemMeta();
        //ItemMeta iron_swordMeta = iron_sword.getItemMeta();
        //ItemMeta diamond_swordMeta = diamond_sword.getItemMeta();
        //ItemMeta bowMeta = bo.getItemMeta();

        //Armor menu


        //Special menu

    }
}
