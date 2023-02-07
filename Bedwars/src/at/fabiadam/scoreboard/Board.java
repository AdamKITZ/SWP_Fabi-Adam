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

    public void updateScoreboard() {
        plugin = MainBedwars.getPlugin();
        util = plugin.getUtil();
        Bukkit.getWorld("world_bedwars").getPlayers().forEach( player -> {
            if (player.getWorld().getName().equals("world_bedwars")) {
                //create a new scoreboard
                Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
                //register a new objective
                Objective object = board.registerNewObjective("test", "dummy");
                //set the display slot to the sidebar
                object.setDisplaySlot(DisplaySlot.SIDEBAR);

                //object.setDisplayName("§a§lScoreboard");

                //set Scoreboard name
                if(player.getName().endsWith("s")) {
                    String playername = player.getName();
                    object.setDisplayName("§a§l" + playername + " Scoreboard");
                } else {
                    String playername = player.getName();
                    object.setDisplayName("§a§l" + playername + "'s Scoreboard");
                }

                object.getScore(" ").setScore(5);

                if(util.red.isBedActive() == true){
                    //checks if the bed is active and if it is, it will display a green checkmark and the team name with team color
                    //if bed is not active, it will display a red cross and the team name with grey
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
                //if the player is not in the bedwars world, then the scoreboard will be removed
                player.removeScoreboardTag("You are not in Bedwars");
            }
        });
    }

    //currently not in use
    //region colorEnum
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
    //endregion
}
