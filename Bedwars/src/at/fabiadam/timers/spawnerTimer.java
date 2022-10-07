package at.fabiadam.timers;

import at.fabiadam.main.MainBedwars;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;


public class spawnerTimer {
    private static int taskId = 0;
    private static World bedwarsWorld;
    private static double time;
    private MainBedwars plugin;
    private FileConfiguration config;

    public void startSpawnerScheduler() {
        plugin = MainBedwars.getPlugin();
        config = plugin.getConfig();
        bedwarsWorld = Bukkit.getWorld("world_bedwars");
        time = 0;
        Bukkit.getScheduler().scheduleSyncRepeatingTask(MainBedwars.getPlugin(), new Runnable() {
            @Override
            public void run() {
                dropBrick();
                if(time/8-(int)(time/8) == 0) {
                    dropIron();
                }
                if(time/40-(int)(time/40) == 0) {
                    dropGold();
                }
                time++;
            }
        }, 0, 20);
    }
    public void dropBrick() {
        bedwarsWorld.dropItem(config.getLocation("spawner.bronze.1.log"), new ItemStack(Material.BRICK));
        bedwarsWorld.dropItem(config.getLocation("spawner.bronze.2.log"), new ItemStack(Material.BRICK));
        bedwarsWorld.dropItem(config.getLocation("spawner.bronze.3.log"), new ItemStack(Material.BRICK));
        bedwarsWorld.dropItem(config.getLocation("spawner.bronze.4.log"), new ItemStack(Material.BRICK));
    }
    public void dropIron() {
        bedwarsWorld.dropItem(config.getLocation("spawner.iron.1.log"), new ItemStack(Material.IRON_INGOT));
        bedwarsWorld.dropItem(config.getLocation("spawner.iron.2.log"), new ItemStack(Material.IRON_INGOT));
        bedwarsWorld.dropItem(config.getLocation("spawner.iron.3.log"), new ItemStack(Material.IRON_INGOT));
        bedwarsWorld.dropItem(config.getLocation("spawner.iron.4.log"), new ItemStack(Material.IRON_INGOT));
    }
    public void dropGold() {
        bedwarsWorld.dropItem(config.getLocation("spawner.gold.1.log"), new ItemStack(Material.GOLD_INGOT));
        bedwarsWorld.dropItem(config.getLocation("spawner.gold.2.log"), new ItemStack(Material.GOLD_INGOT));
        bedwarsWorld.dropItem(config.getLocation("spawner.gold.3.log"), new ItemStack(Material.GOLD_INGOT));
        bedwarsWorld.dropItem(config.getLocation("spawner.gold.4.log"), new ItemStack(Material.GOLD_INGOT));
    }

    public spawnerTimer getSpawnerTimer() {
        return this;
    }
}