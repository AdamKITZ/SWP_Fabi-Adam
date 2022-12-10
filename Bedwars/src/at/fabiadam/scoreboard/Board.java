package at.fabiadam.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class Board {

    public void setScoreboard(Player player) {
        if (player.getWorld().getName().equals("world_bedwars")) {
            Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
            Objective object = board.registerNewObjective("test", "dummy");
            object.setDisplaySlot(DisplaySlot.SIDEBAR);
            object.setDisplayName("§a§lScoreboard");

            if(player.getName().endsWith("s")) {
                String playername = player.getName();
                object.getScore(playername + " Scoreboard").setScore(6);
                /*
                Team team = board.registerNewTeam("team");
                team.addEntry(player.getName());
                team.setPrefix("§7");
                team.setSuffix("§7");
                 */
            } else {
                String playername = player.getName();
                object.getScore(playername + "'s Scoreboard").setScore(6);
                /*
                Team team = board.registerNewTeam("team");
                team.addEntry(player.getName());
                team.setPrefix("§7");
                team.setSuffix("§7s");
                 */
            }

            object.getScore(" ").setScore(5);
            object.getScore("§a✓ §cRed").setScore(4);
            object.getScore("§a✓ §aGreen").setScore(3);
            object.getScore("§a✓ §bBlue").setScore(2);
            object.getScore("§a✓ §yYellow").setScore(1);
            player.setScoreboard(board);
        }

    }

    public void updateScoreboard(Player player) {
        if(player.getWorld().getName().equals("world_bedwars")) {
            Scoreboard board = player.getScoreboard();
            Objective object = board.getObjective("test");
            object.getScore("§a✓ §cRed").setScore(4);
        }
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
