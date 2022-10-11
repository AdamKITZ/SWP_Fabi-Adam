package at.fabiadam.timers;

import at.fabiadam.main.MainBedwars;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;


public class SpawnerTimer {
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
                plugin.saveConfig();
            }
        }, 0, 20);
    }
    public void dropBrick() {
        for(int i = 1; i < 5; i++) {
            if (config.contains("spawner.bronze." + i + ".log")) {
                bedwarsWorld.dropItem(config.getLocation("spawner.bronze." + i + ".log"), new ItemStack(Material.BRICK));
            }
        }
    }
    public void dropIron() {
        for(int i = 1; i < 5; i++) {
            if (config.contains("spawner.bronze." + i + ".log")) {
                bedwarsWorld.dropItem(config.getLocation("spawner.bronze." + i + ".log"), new ItemStack(Material.IRON_INGOT));
            }
        }
    }
    public void dropGold() {
        for(int i = 1; i < 5; i++) {
            if (config.contains("spawner.bronze." + i + ".log")) {
                bedwarsWorld.dropItem(config.getLocation("spawner.bronze." + i + ".log"), new ItemStack(Material.GOLD_INGOT));
            }
        }
    }


    public SpawnerTimer getSpawnerTimer() {
        return this;
    }
}