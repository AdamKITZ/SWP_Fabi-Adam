package at.fabiadam.util;

import at.fabiadam.main.MainBedwars;
import at.fabiadam.objects.Team;
import at.fabiadam.scoreboard.Board;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class BedwarsUtil {
    private MainBedwars plugin;

    private Board board;
    public List<Team> teamList = new ArrayList<>();
    public Team red;
    public Team blue;
    public Team green;
    public Team yellow;


    public void start() {
        plugin = MainBedwars.getPlugin();
        board = plugin.getBoard();
        FileConfiguration config = plugin.getConfig();
        red = new Team("red", 1, config.getLocation("team.red.teamSpawn"), true);
        blue = new Team("blue", 1, config.getLocation("team.blue.teamSpawn"), true);
        green = new Team("green", 1, config.getLocation("team.green.teamSpawn"), true);
        yellow = new Team("yellow", 1, config.getLocation("team.yellow.teamSpawn"), true);
        teamList.add(red);
        teamList.add(blue);
        teamList.add(green);
        boolean add = teamList.add(yellow);


        //Each player should be put into a team --> If team is full, try next team
        List<Player> players = Bukkit.getServer().getWorld("world_bedwars").getPlayers();
        players.forEach(p -> {
            for (int i = 0; i < 4; i++) {
                if (teamList.get(i).getPlayerCount() < teamList.get(i).getMaxPlayerCount()) {
                    teamList.get(i).addPlayer(p);
                    p.sendMessage(MainBedwars.PREFIX + "You are in team " + teamList.get(i).getTeamColor());
                    board.updateScoreboard();

                    break;
                }
            }
        });

    }

    public Team getPlayerTeam(Player player) {
        for (int i = 0; i < 4; i++) {
            if (teamList.get(i).getPlayers().contains(player)) {
                return teamList.get(i);
            }
        }
        return null;
    }

    public int isBedActiv(Player player) {
        Team team = getPlayerTeam(player);
        if (team.isBedActive()) {
            return 1;
        } else {
            return 0;
        }
    }

    public void setPlayersReady() {
        Bukkit.getWorld("world_bedwars_l").getPlayers().forEach(p -> {
            if(p.isDead()) {
                p.spigot().respawn();
            }
            //p.setVelocity(0, 0, 0);
            //p.setWalkSpeed(0);
            p.teleport(new Location(Bukkit.getWorld("world_bedwars"), 0, 100, 0));
        });
    }

    public void teleportTeams() {
        teamList.forEach(team -> {
            if (team.getPlayerCount() > 0) {
                team.getPlayers().forEach(p -> {
                    p.teleport(team.getTeamSpawn());
                });
            }
        });
    }

    public List<Location> getSpawnBlocks(Location spawn) {
        spawn = spawn.getBlock().getLocation();
        List<Location> spawnBlocks = new ArrayList<>();
        spawnBlocks.add(spawn);
        spawnBlocks.add(new Location(spawn.getWorld(), spawn.getX() + 1, spawn.getY(), spawn.getZ()));
        spawnBlocks.add(new Location(spawn.getWorld(), spawn.getX() - 1, spawn.getY(), spawn.getZ()));
        spawnBlocks.add(new Location(spawn.getWorld(), spawn.getX(), spawn.getY(), spawn.getZ() + 1));
        spawnBlocks.add(new Location(spawn.getWorld(), spawn.getX(), spawn.getY(), spawn.getZ() - 1));
        spawnBlocks.add(new Location(spawn.getWorld(), spawn.getX() + 1, spawn.getY(), spawn.getZ() + 1));
        spawnBlocks.add(new Location(spawn.getWorld(), spawn.getX() - 1, spawn.getY(), spawn.getZ() - 1));
        spawnBlocks.add(new Location(spawn.getWorld(), spawn.getX() + 1, spawn.getY(), spawn.getZ() - 1));
        spawnBlocks.add(new Location(spawn.getWorld(), spawn.getX() - 1, spawn.getY(), spawn.getZ() + 1));
        spawnBlocks.add(new Location(spawn.getWorld(), spawn.getX(), spawn.getY() + 1, spawn.getZ()));
        spawnBlocks.add(new Location(spawn.getWorld(), spawn.getX() + 1, spawn.getY() + 1, spawn.getZ()));
        spawnBlocks.add(new Location(spawn.getWorld(), spawn.getX() - 1, spawn.getY() + 1, spawn.getZ()));
        spawnBlocks.add(new Location(spawn.getWorld(), spawn.getX(), spawn.getY() + 1, spawn.getZ() + 1));
        spawnBlocks.add(new Location(spawn.getWorld(), spawn.getX(), spawn.getY() + 1, spawn.getZ() - 1));
        spawnBlocks.add(new Location(spawn.getWorld(), spawn.getX() + 1, spawn.getY() + 1, spawn.getZ() + 1));
        spawnBlocks.add(new Location(spawn.getWorld(), spawn.getX() - 1, spawn.getY() + 1, spawn.getZ() - 1));
        spawnBlocks.add(new Location(spawn.getWorld(), spawn.getX() + 1, spawn.getY() + 1, spawn.getZ() - 1));
        spawnBlocks.add(new Location(spawn.getWorld(), spawn.getX() - 1, spawn.getY() + 1, spawn.getZ() + 1));
        return spawnBlocks;
    }

}
