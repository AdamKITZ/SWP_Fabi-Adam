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
    static ItemStack iron_sword = new ItemStack(Material.IRON_SWORD);
    static ItemStack stone_sword = new ItemStack(Material.STONE_SWORD);
    static ItemStack bow = new ItemStack(Material.BOW);
    static ItemStack wooden_axe = new ItemStack(Material.WOODEN_AXE);
    static ItemStack stone_axe = new ItemStack(Material.STONE_AXE);


    //Armor menu
    static ItemStack chainmail_chestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
    static ItemStack iron_chestplate = new ItemStack(Material.IRON_CHESTPLATE);
    static ItemStack diamond_chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
    static ItemStack leather_chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
    static ItemStack leather_helmet = new ItemStack(Material.LEATHER_HELMET);
    static ItemStack leather_leggings = new ItemStack(Material.LEATHER_LEGGINGS);
    static ItemStack leather_boots = new ItemStack(Material.LEATHER_BOOTS);

    //Special menu
    static ItemStack fire_charge = new ItemStack(Material.FIRE_CHARGE);
    static ItemStack ender_pearl = new ItemStack(Material.ENDER_PEARL);
    static ItemStack snowball = new ItemStack(Material.SNOWBALL);
    static ItemStack healing_potion = new ItemStack(Material.POTION);

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
        sandstoneMeta.setDisplayName("§b16 Sandstone 16 Bronze");
        end_stoneMeta.setDisplayName("§b1 End Stone 6 Bronze");
        obsidianMeta.setDisplayName("§b4 Obsidian 4 Gold");
        glassMeta.setDisplayName("§b1 Glass 2 Bronze");
        glowstoneMeta.setDisplayName("§b2 Glowstone 4 Bronze");
        nether_brickMeta.setDisplayName("§b1 Nether Brick 2 Bronze");
        infested_stoneMeta.setDisplayName("§b1 Infested Stone 24 Bronze");
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

        ItemMeta stone_swordMeta = stone_sword.getItemMeta();
        ItemMeta iron_swordMeta = iron_sword.getItemMeta();
        ItemMeta diamond_swordMeta = diamond_sword.getItemMeta();
        ItemMeta bowMeta = bow.getItemMeta();
        ItemMeta wooden_axeMeta = wooden_axe.getItemMeta();
        ItemMeta stone_axeMeta = stone_axe.getItemMeta();
        stone_swordMeta.setDisplayName("§bStone Sword 1 Bronze");
        iron_swordMeta.setDisplayName("§bIron Sword 2 Bronze");
        diamond_swordMeta.setDisplayName("§bDiamond Sword 3 Bronze");
        bowMeta.setDisplayName("§bBow 2 Bronze");
        wooden_axeMeta.setDisplayName("§bWooden Axe 12 Bronze");
        stone_axeMeta.setDisplayName("§bStone Axe 2 Iron");
        stone_sword.setItemMeta(stone_swordMeta);
        iron_sword.setItemMeta(iron_swordMeta);
        diamond_sword.setItemMeta(diamond_swordMeta);
        bow.setItemMeta(bowMeta);
        wooden_axe.setItemMeta(wooden_axeMeta);
        stone_axe.setItemMeta(stone_axeMeta);

        //Armor menu
        ItemMeta chainmail_chestplateMeta = chainmail_chestplate.getItemMeta();
        ItemMeta iron_chestplateMeta = iron_chestplate.getItemMeta();
        ItemMeta diamond_chestplateMeta = diamond_chestplate.getItemMeta();
        ItemMeta leather_chestplateMeta = leather_chestplate.getItemMeta();
        ItemMeta leather_helmetMeta = leather_helmet.getItemMeta();
        ItemMeta leather_leggingsMeta = leather_leggings.getItemMeta();
        ItemMeta leather_bootsMeta = leather_boots.getItemMeta();
        chainmail_chestplateMeta.setDisplayName("§bChainmail Chestplate 32 Bronze");
        iron_chestplateMeta.setDisplayName("§bIron Chestplate 12 Iron");
        diamond_chestplateMeta.setDisplayName("§bDiamond Chestplate 16 Gold");
        leather_chestplateMeta.setDisplayName("§bLeather Chestplate 2 Iron");
        leather_helmetMeta.setDisplayName("§bLeather Helmet 2 Iron");
        leather_leggingsMeta.setDisplayName("§bLeather Leggings 2 Iron");
        leather_bootsMeta.setDisplayName("§bLeather Boots 2 Iron");
        chainmail_chestplate.setItemMeta(chainmail_chestplateMeta);
        iron_chestplate.setItemMeta(iron_chestplateMeta);
        diamond_chestplate.setItemMeta(diamond_chestplateMeta);
        leather_chestplate.setItemMeta(leather_chestplateMeta);
        leather_helmet.setItemMeta(leather_helmetMeta);
        leather_leggings.setItemMeta(leather_leggingsMeta);
        leather_boots.setItemMeta(leather_bootsMeta);

        //Special menu
        ItemMeta fire_chargeMeta = fire_charge.getItemMeta();
        ItemMeta ender_pearlMeta = ender_pearl.getItemMeta();
        ItemMeta snowballMeta = snowball.getItemMeta();
        ItemMeta healing_potionMeta = healing_potion.getItemMeta();
        fire_chargeMeta.setDisplayName("§bFire Charge 2 Iron");
        ender_pearlMeta.setDisplayName("§bEnder Pearl 11 Gold");
        snowballMeta.setDisplayName("§bSnowball 8 Bronze");
        healing_potionMeta.setDisplayName("§bHealing Potion 3 Iron");
        fire_charge.setItemMeta(fire_chargeMeta);
        ender_pearl.setItemMeta(ender_pearlMeta);
        snowball.setItemMeta(snowballMeta);
        healing_potion.setItemMeta(healing_potionMeta);
    }
}
