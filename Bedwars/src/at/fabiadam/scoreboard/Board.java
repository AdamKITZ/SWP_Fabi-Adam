package at.fabiadam.scoreboard;

import at.fabiadam.main.MainBedwars;
import at.fabiadam.util.BedwarsUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.List;

public class Board {
    MainBedwars plugin;
    BedwarsUtil util;

    //timer which updates the scoreboard every second and changes the color of setScore(6)
    public void updateScoreboard() {
        plugin = MainBedwars.getPlugin();
        util = plugin.getUtil();
        Bukkit.getWorld("world_bedwars").getPlayers().forEach( player -> {
            if (player.getWorld().getName().equals("world_bedwars")) {
                Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
                Objective object = board.registerNewObjective("test", "dummy");
                object.setDisplaySlot(DisplaySlot.SIDEBAR);
                object.setDisplayName("§a§lScoreboard");

                if(player.getName().endsWith("s")) {
                    String playername = player.getName();
                    object.getScore(playername + " Scoreboard").setScore(6);
                } else {
                    String playername = player.getName();
                    object.getScore(playername + "'s Scoreboard").setScore(6);
                }

                object.getScore(" ").setScore(5);

                if(util.red.isBedActive() == true){
                    object.getScore("§a§l✓§r §cRed").setScore(4);
                } else {
                    List<Player> redPlayers = util.red.getPlayers();
                    for(Player p : redPlayers) {
                        if(p.isDead()) {
                            object.getScore("§c✘ §7§mRed").setScore(4);
                        }
                        else {
                            object.getScore("§c✘ §cRed").setScore(4);
                        }
                    }
                }

                if(util.green.isBedActive() == true){
                    object.getScore("§a§l✓§r §aGreen").setScore(3);
                } else {
                    List<Player> redPlayers = util.green.getPlayers();
                    for(Player p : redPlayers) {
                        if(p.isDead()) {
                            object.getScore("§c✘ §7§mGreen").setScore(3);
                        }
                        else {
                            object.getScore("§c✘ §aGreen").setScore(3);
                        }
                    }
                }

                if(util.blue.isBedActive() == true){
                    object.getScore("§a§l✓§r §bBlue").setScore(2);
                } else {
                    List<Player> redPlayers = util.blue.getPlayers();
                    for(Player p : redPlayers) {
                        if(p.isDead()) {
                            object.getScore("§c✘ §7§mBlue").setScore(2);
                        }
                        else {
                            object.getScore("§c✘ §bBlue").setScore(2);
                        }
                    }
                }

                if(util.yellow.isBedActive() == true){
                    object.getScore("§a§l✓§r §eYellow").setScore(1);
                } else {
                    List<Player> redPlayers = util.yellow.getPlayers();
                    for(Player p : redPlayers) {
                        if(p.isDead()) {
                            object.getScore("§c✘ §7§mYellow").setScore(1);
                        }
                        else {
                            object.getScore("§c✘ §yYellow").setScore(1);
                        }
                    }
                }

                player.setScoreboard(board);
            } else if (player.getWorld().getName().equals("world_bedwars_l")|| player.getWorld().getName().equals("world")) {
                player.removeScoreboardTag("You are not in Bedwars");
            }
        });
    }

    private ColourEnum getColourEnum(Player player){
        if(player.getWorld().getName().equals("world_bedwars")){
            if(player.getDisplayName().contains("§y")){
                return ColourEnum.ENTRY_0;
            } else if(player.getDisplayName().contains("§cc")){
                return ColourEnum.ENTRY_1;
            } else if(player.getDisplayName().contains("§c")){
                return ColourEnum.ENTRY_2;
            }
        }
        return null;
    }

    private Team getTeam(Player player){
        if(player.getWorld().getName().equals("world_bedwars")){
            Scoreboard board = player.getScoreboard();
            if(board.getTeam(getColourEnum(player).getEntryString()) == null){
                Team team = board.registerNewTeam(getColourEnum(player).getEntryString());
                team.addEntry(getColourEnum(player).getEntryString());
                return team;
            } else {
                return board.getTeam(getColourEnum(player).getEntryString());
            }
        }
        return null;
    }
}
