package at.fabiadam.scoreboard;

import  org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class Board {


    public void setScoreboard(Player player){
        if(player.getWorld().getName().equals("world_bedwars")){
            Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
            Objective object = board.registerNewObjective("test", "dummy");

            object.setDisplaySlot(DisplaySlot.SIDEBAR);
            object.setDisplayName("§a§lScoreboard");

            object.getScore(Bukkit.getName() + "'s Scoreboard").setScore(6);
            object.getScore(" ").setScore(5);
            object.getScore("§a✓ §cRed").setScore(4);
            object.getScore("§a✓ §aGreen").setScore(3);
            object.getScore("§a✓ §bBlue").setScore(2);
            object.getScore("§a✓ §yYellow").setScore(1);
            player.setScoreboard(board);
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
