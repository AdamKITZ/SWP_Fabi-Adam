package at.fabiadam.util;

import at.fabiadam.main.MainBedwars;
import at.fabiadam.objects.Team;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class BedwarsUtil {
    public List<Team> teamList = new ArrayList<>();
    public Team red;
    public Team blue;
    public Team green;
    public Team yellow;
    public void start() {
        Bukkit.broadcastMessage("Players in lobby: " + Bukkit.getServer().getWorld("world_bedwars_l").getPlayers().size());
        Bukkit.broadcastMessage("Players in game: " + Bukkit.getServer().getWorld("world_bedwars").getPlayers().size());
        Bukkit.broadcastMessage("Players in world: " + Bukkit.getServer().getWorld("world").getPlayers().size());
        red = new Team("red", 0, 1, new ArrayList<Player>(), true);
        blue = new Team("blue", 0, 1, new ArrayList<Player>(), true);
        green = new Team("green", 0, 1,new ArrayList<Player>(), true);
        yellow = new Team("yellow", 0, 1, new ArrayList<Player>(), true);
        teamList.add(red);
        teamList.add(blue);
        teamList.add(green);
        teamList.add(yellow);
        //Each player should be put into a team --> If team is full, try next team
        Bukkit.broadcastMessage("Players in game: " + Bukkit.getServer().getWorld("world_bedwars").getPlayers().size());
        List<Player> players = Bukkit.getServer().getWorld("world_bedwars").getPlayers();
        Bukkit.broadcastMessage("player in list:" + players.size());
        players.forEach(p -> {
            for(int i = 0; i<4; i++) {
                if(teamList.get(i).getPlayerCount() < teamList.get(i).getMaxPlayerCount()) {
                    teamList.get(i).addPlayer(p);
                    p.sendMessage("You are in team " + teamList.get(i).getTeamColor());
                    break;
                }
            }
        });

    }

    public void notifyPlayers() {
        for (Team team : teamList) {
            team.getPlayers().forEach(player -> {
                player.sendMessage("You are in team " + team.getColor());
            });
        }
    }
}
