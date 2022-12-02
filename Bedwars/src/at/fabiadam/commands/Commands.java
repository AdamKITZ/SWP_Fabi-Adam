package at.fabiadam.commands;

import at.fabiadam.main.MainBedwars;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class  Commands implements CommandExecutor, TabCompleter {
    public MainBedwars plugin;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        plugin = MainBedwars.getPlugin();
        if (sender instanceof Player) {
            if (command.getName().equalsIgnoreCase("bw")) {
                Player player = (Player) sender;
                switch (args[0].toLowerCase()) {
                    case "setspawner":
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
                        break;
                    case "setbed":
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
                        break;
                    case "setspawn":
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
                    default:
                        break;
                }
            }
        } else {
            sender.sendMessage("§cYou can only do this as a player!");
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        List<String> result = new ArrayList<>();
        if (strings.length == 1) {
            result.add("setspawner");
            result.add("setbed");
            result.add("setspawn");
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
