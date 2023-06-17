package at.fabiadam.util;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ShopItems {
    //Main Menu
    static ItemStack blocks = new ItemStack(Material.SANDSTONE);
    static ItemStack weapons = new ItemStack(Material.DIAMOND_SWORD);
    static ItemStack armor = new ItemStack(Material.DIAMOND_CHESTPLATE);
    static ItemStack special = new ItemStack(Material.FIRE_CHARGE);

    //Back Button
    static ItemStack red_dye = new ItemStack(Material.RED_DYE);

    //Blocks Menu
    static ItemStack sandstone = new ItemStack(Material.SANDSTONE);
    static ItemStack end_stone = new ItemStack(Material.END_STONE);
    static ItemStack obsidian = new ItemStack(Material.OBSIDIAN);
    static ItemStack glass = new ItemStack(Material.GLASS);
    static ItemStack glowstone = new ItemStack(Material.GLOWSTONE);
    static ItemStack nether_brick = new ItemStack(Material.PACKED_ICE);
    static ItemStack infested_stone = new ItemStack(Material.INFESTED_STONE);
    //chest
    static ItemStack chest = new ItemStack(Material.CHEST);

    //Weapons menu
    static ItemStack stick = new ItemStack(Material.STICK);
    static ItemStack diamond_sword = new ItemStack(Material.DIAMOND_SWORD);
    static ItemStack iron_sword = new ItemStack(Material.IRON_SWORD);
    static ItemStack stone_sword = new ItemStack(Material.STONE_SWORD);
    static ItemStack bow = new ItemStack(Material.BOW);
    //static ItemStack wooden_axe = new ItemStack(Material.WOODEN_AXE);
    static ItemStack stone_axe = new ItemStack(Material.STONE_AXE);
    static ItemStack stone_pickaxe = new ItemStack(Material.STONE_PICKAXE);
    //Iron Pickaxe
    static ItemStack iron_pickaxe = new ItemStack(Material.IRON_PICKAXE);
    //Golden Pickaxe
    static ItemStack golden_pickaxe = new ItemStack(Material.GOLDEN_PICKAXE);
    //Diamond Pickaxe
    static ItemStack diamond_pickaxe = new ItemStack(Material.DIAMOND_PICKAXE);
    //Arrow
    static ItemStack arrow = new ItemStack(Material.ARROW);


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
    static PotionEffect potionEffect = new PotionEffect(PotionEffectType.HEAL, 1, 1);

    //Back Button
    static ItemStack back = new ItemStack(Material.RED_DYE);

    public static void renameAll() {
        //Main menu
        ItemMeta blocksMeta = blocks.getItemMeta();
        ItemMeta weaponsMeta = weapons.getItemMeta();
        ItemMeta armorMeta = armor.getItemMeta();
        ItemMeta specialMeta = special.getItemMeta();
        blocksMeta.setDisplayName("Blocks");
        weaponsMeta.setDisplayName("Weapons");
        armorMeta.setDisplayName("Armor");
        specialMeta.setDisplayName("Special");
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
        ItemMeta red_dyeMeta = red_dye.getItemMeta();
        sandstoneMeta.setDisplayName("2 Sandstone 1 Bronze");
        end_stoneMeta.setDisplayName("1 End Stone 6 Bronze");
        obsidianMeta.setDisplayName("4 Obsidian 4 Gold");
        glassMeta.setDisplayName("1 Glass 2 Bronze");
        glowstoneMeta.setDisplayName("2 Glowstone 4 Bronze");
        nether_brickMeta.setDisplayName("1 Nether Brick 2 Bronze");
        infested_stoneMeta.setDisplayName("1 Infested Stone 24 Bronze");
        sandstone.setItemMeta(sandstoneMeta);
        end_stone.setItemMeta(end_stoneMeta);
        obsidian.setItemMeta(obsidianMeta);
        glass.setItemMeta(glassMeta);
        glowstone.setItemMeta(glowstoneMeta);
        nether_brick.setItemMeta(nether_brickMeta);
        infested_stone.setItemMeta(infested_stoneMeta);
        //chest
        ItemMeta chestMeta = chest.getItemMeta();
        chestMeta.setDisplayName("1 Chest 8 Iron");
        chest.setItemMeta(chestMeta);

        //Weapons menu
        //Knockbackstick
        ItemMeta stickMeta = stick.getItemMeta();
        stick.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
        //stick.setItemMeta(stickMeta);
        ItemMeta stickNewMeta = stick.getItemMeta();
        stickNewMeta.setDisplayName("1 Knockback Stick 7 Bronze");
        stick.setItemMeta(stickNewMeta);

        ItemMeta stone_swordMeta = stone_sword.getItemMeta();
        ItemMeta iron_swordMeta = iron_sword.getItemMeta();
        ItemMeta diamond_swordMeta = diamond_sword.getItemMeta();
        ItemMeta bowMeta = bow.getItemMeta();
        //ItemMeta wooden_axeMeta = wooden_axe.getItemMeta();
        ItemMeta stone_pickaxeMeta = stone_axe.getItemMeta();
        ItemMeta stone_axeMeta = stone_axe.getItemMeta();
        stone_swordMeta.setDisplayName("1 Stone Sword 1 Bronze");
        iron_swordMeta.setDisplayName("1 Iron Sword 12 Iron");
        diamond_swordMeta.setDisplayName("1 Diamond Sword 6 Gold");
        bowMeta.setDisplayName("1 Bow 2 Bronze");
        //wooden_axeMeta.setDisplayName("1 Wooden Axe 12 Bronze");
        stone_pickaxeMeta.setDisplayName("1 Stone Pickaxe 30 Bronze");
        stone_axeMeta.setDisplayName("1 Stone Axe 2 Iron");
        stone_sword.setItemMeta(stone_swordMeta);
        iron_sword.setItemMeta(iron_swordMeta);
        diamond_sword.setItemMeta(diamond_swordMeta);
        bow.setItemMeta(bowMeta);
        //wooden_axe.setItemMeta(wooden_axeMeta);
        stone_pickaxe.setItemMeta(stone_pickaxeMeta);
        stone_axe.setItemMeta(stone_axeMeta);
        //Iron Pickaxe
        ItemMeta iron_pickaxeMeta = iron_pickaxe.getItemMeta();
        iron_pickaxeMeta.setDisplayName("1 Iron Pickaxe 12 Iron");
        iron_pickaxe.setItemMeta(iron_pickaxeMeta);
        //Gold Pickaxe
        ItemMeta gold_pickaxeMeta = golden_pickaxe.getItemMeta();
        gold_pickaxeMeta.setDisplayName("1 Gold Pickaxe 6 Gold");
        golden_pickaxe.setItemMeta(gold_pickaxeMeta);
        //Diamond Pickaxe
        ItemMeta diamond_pickaxeMeta = diamond_pickaxe.getItemMeta();
        diamond_pickaxeMeta.setDisplayName("1 Diamond Pickaxe 2 Gold");
        diamond_pickaxe.setItemMeta(diamond_pickaxeMeta);
        //Arrow
        ItemMeta arrowMeta = arrow.getItemMeta();
        arrowMeta.setDisplayName("1 Arrow 1 Bronze");
        arrow.setItemMeta(arrowMeta);

        //Armor menu
        ItemMeta chainmail_chestplateMeta = chainmail_chestplate.getItemMeta();
        ItemMeta iron_chestplateMeta = iron_chestplate.getItemMeta();
        ItemMeta diamond_chestplateMeta = diamond_chestplate.getItemMeta();
        ItemMeta leather_chestplateMeta = leather_chestplate.getItemMeta();
        ItemMeta leather_helmetMeta = leather_helmet.getItemMeta();
        ItemMeta leather_leggingsMeta = leather_leggings.getItemMeta();
        ItemMeta leather_bootsMeta = leather_boots.getItemMeta();
        chainmail_chestplateMeta.setDisplayName("1 Chainmail Chestplate 32 Bronze");
        iron_chestplateMeta.setDisplayName("1 Iron Chestplate 12 Iron");
        diamond_chestplateMeta.setDisplayName("1 Diamond Chestplate 16 Gold");
        leather_chestplateMeta.setDisplayName("1 Leather Chestplate 2 Iron");
        leather_helmetMeta.setDisplayName("1 Leather Helmet 2 Iron");
        leather_leggingsMeta.setDisplayName("1 Leather Leggings 2 Iron");
        leather_bootsMeta.setDisplayName("1 Leather Boots 2 Iron");
        chainmail_chestplate.setItemMeta(chainmail_chestplateMeta);
        iron_chestplate.setItemMeta(iron_chestplateMeta);
        diamond_chestplate.setItemMeta(diamond_chestplateMeta);
        leather_chestplate.setItemMeta(leather_chestplateMeta);
        leather_helmet.setItemMeta(leather_helmetMeta);
        leather_leggings.setItemMeta(leather_leggingsMeta);
        leather_boots.setItemMeta(leather_bootsMeta);

        //Special menu

        //healing potion
        PotionMeta healing_potionMeta = (PotionMeta) healing_potion.getItemMeta();
        healing_potionMeta.addCustomEffect(new PotionEffect(PotionEffectType.HEAL, 60*20,1), true);
        healing_potionMeta.setDisplayName("1 Healing Potion 4 Iron");
        healing_potion.setItemMeta(healing_potionMeta);

        //throwable fire charge which explodes on impact
        ItemMeta fire_chargeMeta = fire_charge.getItemMeta();
        fire_chargeMeta.addEnchant(Enchantment.DURABILITY, 1, false);
        fire_chargeMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        fire_chargeMeta.setDisplayName("2 Fire Charge 8 Iron");
        fire_charge.setItemMeta(fire_chargeMeta);

        ItemMeta ender_pearlMeta = ender_pearl.getItemMeta();
        ItemMeta snowballMeta = snowball.getItemMeta();
        ender_pearlMeta.setDisplayName("1 Ender Pearl 11 Gold");
        snowballMeta.setDisplayName("16 Snowball 8 Bronze");
        ender_pearl.setItemMeta(ender_pearlMeta);
        snowball.setItemMeta(snowballMeta);

        //Back button

        ItemMeta backMeta = back.getItemMeta();
        backMeta.setDisplayName("Back");
        back.setItemMeta(backMeta);
    }
}
