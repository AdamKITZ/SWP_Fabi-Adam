package at.fabiadam.util;

import at.fabiadam.main.MainBedwars;
import at.fabiadam.objects.Team;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class BedwarsUtil {
    private MainBedwars plugin;
    public List<Team> teamList = new ArrayList<>();
    public Team red;
    public Team blue;
    public Team green;
    public Team yellow;
    public void start() {
        plugin = MainBedwars.getPlugin();
        FileConfiguration config = plugin.getConfig();
        red = new Team("red", 1, config.getLocation("team.red.teamSpawn"));
        blue = new Team("blue", 1, config.getLocation("team.green.teamSpawn"));
        green = new Team("green", 1,  config.getLocation("team.blue.teamSpawn"));
        yellow = new Team("yellow", 1,  config.getLocation("team.yellow.teamSpawn"));
        teamList.add(red);
        teamList.add(blue);
        teamList.add(green);
        teamList.add(yellow);
        //Each player should be put into a team --> If team is full, try next team
        List<Player> players = Bukkit.getServer().getWorld("world_bedwars").getPlayers();
        players.forEach(p -> {
            for(int i = 0; i<4; i++) {
                if(teamList.get(i).getPlayerCount() < teamList.get(i).getMaxPlayerCount()) {
                    teamList.get(i).addPlayer(p);
                    p.sendMessage(MainBedwars.PREFIX + "You are in team " + teamList.get(i).getTeamColor());
                    break;
                }
            }
        });

    }

    public void teleportTeams() {
        teamList.forEach(team -> {
            if(team.getPlayerCount() > 0) {
                team.getPlayers().forEach(p -> {
                    p.teleport(team.getTeamSpawn());
                });
            }
        });
    }

}
