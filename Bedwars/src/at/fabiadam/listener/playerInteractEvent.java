package at.fabiadam.listener;


import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ItemMergeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class playerInteractEvent implements Listener {
    public List<FallingBlock> fireNades = new ArrayList<>();

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (player.getWorld().getName().equals("world_bedwars_l")) {
            if (player.getGameMode() == GameMode.SURVIVAL) {
                event.setCancelled(true);
                //checks if the player location is > 70, if so cancel the damage (lobby)
                if (player.getLocation().getY() <= 70) {
                    if (!player.getInventory().contains(Material.STICK)) {
                        ItemStack stick = new ItemStack(Material.STICK);
                        stick.addUnsafeEnchantment(Enchantment.KNOCKBACK, 3);
                        ItemMeta stickMeta = stick.getItemMeta();
                        stickMeta.setDisplayName("§6§lKnockback Stick");
                        stick.setItemMeta(stickMeta);
                        //player receives a knockback stick
                        player.getInventory().addItem(stick);
                    }
                }
            }
        } else if (player.getWorld().getName().equals("world_bedwars")) {

            Material[] materials = {Material.RED_BED, Material.GREEN_BED, Material.BLUE_BED, Material.YELLOW_BED};

            if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                //player is not allowed to interact with beds (sleep)
                if (Arrays.asList(materials).contains(event.getClickedBlock().getType())) {
                    event.setCancelled(true);
                }
            } else if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_AIR) {
                if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta() != null) {
                    if(event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.FIRE_CHARGE)) {
                        FallingBlock fireCharge = player.getWorld().spawnFallingBlock(player.getLocation(), Material.TNT, (byte) 0);
                        fireCharge.setDropItem(false);
                        fireNades.add(fireCharge);
                        fireCharge.setVelocity(player.getLocation().getDirection().multiply(2));
                        fireNades.add(fireCharge);
                        event.setCancelled(true);
                    }
                }
            }
        }
    }
}