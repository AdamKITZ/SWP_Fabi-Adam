package at.fabiadam.commands;

import at.fabiadam.main.MainBedwars;
import at.fabiadam.objects.Team;
import at.fabiadam.util.BedwarsUtil;
import at.fabiadam.util.MapReset;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;



//Class commands that handles all commands, i also added a tab completer for easy tap completion
public class  Commands implements CommandExecutor, TabCompleter {
    public MainBedwars plugin;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        plugin = MainBedwars.getPlugin();
        if (sender instanceof Player) {
            if (command.getName().equalsIgnoreCase("bw")) {
                Player player = (Player) sender;

                //This switch-case checks the actuall command
                //All bw related commands start with /bw
                //After that we have setspawner, setbed, setspawn... e.g. /bw setspawner bronze 1
                switch (args[0].toLowerCase()) {
                    //In each case, the parameter after the command is checked
                    case "setspawner":
                        setSpawner(plugin, player, command, args);
                        break;
                    case "setbed":
                        setBed(plugin, player, command, args);
                        break;
                    case "setspawn":
                        setSpawn(plugin, player, command, args);
                        break;
                    case "test":
                        if(player.hasPermission("bedwars.test")) {
                            MapReset mapReset = plugin.getMapReset();
                            mapReset.restore();
                        }
                        break;
                    case "spawnshop":
                        spawnshop(plugin, player, command, args);
                        break;
                }
            }
        } else {
            sender.sendMessage("§cYou can only do this as a player!");
        }
        return true;
    }

    public void setSpawner(MainBedwars plugin, Player player, Command command, String[] args) {
        if (player.hasPermission("bedwars.setspawner")) {
            if (player.getWorld().getName().equals("world_bedwars")) {
                if (args.length == 3) {
                    if (args[1].equalsIgnoreCase("bronze") || args[1].equalsIgnoreCase("iron") || args[1].equalsIgnoreCase("gold")) {
                        if (args[2].matches("[1-4]+")) {
                            FileConfiguration config = plugin.getConfig();
                            config.set("spawner." + args[1] + "." + args[2] + ".loc", player.getLocation());
                            player.sendMessage("§b" + args[1].toUpperCase() + " spawner set!");
                            plugin.saveConfig();
                        }
                    }
                } else {
                    player.sendMessage("Usage: " + command.getUsage());
                }
            } else {
                player.sendMessage("§cYou can not do this on your current world!");
            }
        } else {
            player.sendMessage("§cYou do not have enough permission to perform this action!");
        }
    }

    public void setBed(MainBedwars plugin, Player player, Command command, String[] args) {
        if (player.hasPermission("bedwars.setbed")) {
            if (player.getWorld().getName().equals("world_bedwars")) {
                if (args.length == 2) {
                    if (args[1].equalsIgnoreCase("red") || args[1].equalsIgnoreCase("blue") || args[1].equalsIgnoreCase("green") || args[1].equalsIgnoreCase("yellow")) {
                        FileConfiguration config = plugin.getConfig();
                        config.set("bed." + args[1] + ".loc", player.getLocation());
                        player.sendMessage("§b" + args[1].toUpperCase() + " bed set!");
                        plugin.saveConfig();
                    }
                } else {
                    player.sendMessage("Usage: " + command.getUsage());
                }

            } else {
                player.sendMessage("§cYou can not do this on your current world!");
            }
        } else {
            player.sendMessage("§cYou do not have enough permission to perform this action!");
        }
    }

    public void setSpawn(MainBedwars plugin, Player player, Command command, String[] args) {
        if (player.hasPermission("bedwars.setspawn")) {
            if (player.getWorld().getName().equals("world_bedwars")) {
                if (args.length == 2) {
                    if (args[1].equalsIgnoreCase("red") || args[1].equalsIgnoreCase("blue") || args[1].equalsIgnoreCase("green") || args[1].equalsIgnoreCase("yellow")) {
                        FileConfiguration config = plugin.getConfig();
                        config.set("team." + args[1] + ".teamSpawn", player.getLocation());
                        player.sendMessage("§b" + args[1].toUpperCase() + " spawn set!");
                        plugin.saveConfig();
                    } else {
                        player.sendMessage("Usage: " + command.getUsage());
                    }
                } else {
                    player.sendMessage("Usage: " + command.getUsage());
                }
            }
        } else {
            player.sendMessage("§cYou do not have enough permission to perform this action!");
        }
    }

    public void spawnshop(MainBedwars plugin, Player player, Command command, String[] args) {
        Villager shop = (Villager) player.getWorld().spawnEntity(player.getLocation(), EntityType.VILLAGER);
        shop.setAI(false);
        shop.setCustomName("§bShop");
        shop.setCustomNameVisible(true);
        shop.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 500));
    }

    //This method is called when a player taps tab
    //If you for example write "/bw s" and tap tab, it will complete the command to "/bw setspawner"
    //Depending on in which case you are, it will complete the command with the right parameters
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        List<String> result = new ArrayList<>();
        if (strings.length == 1) {
            result.add("setspawner");
            result.add("setbed");
            result.add("setspawn");
            result.add("spawnshop");
        } else if (strings.length == 2) {
            switch (strings[0].toLowerCase()) {
                case "setspawner":
                    result.add("bronze");
                    result.add("iron");
                    result.add("gold");
                    break;
                case "setbed":
                case "setspawn":
                    result.add("red");
                    result.add("blue");
                    result.add("green");
                    result.add("yellow");
                    break;
                default:
                    break;
            }
        }
        return result;
    }
}
