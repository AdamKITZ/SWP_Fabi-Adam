package at.fabiadam.util;

import at.fabiadam.main.MainBedwars;
import at.fabiadam.objects.Team;
import at.fabiadam.scoreboard.Board;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class BedwarsUtil {
    //I think the most important logic is in this class
    //It handles everything that needs to be done in the game, like teleporting and setting the Team values
    //We also use this to make ingame-realted map changes, like deleting items
    //But this class will later on be embedded in the GameStates
    private MainBedwars plugin;

    private Board board;
    public List<Team> teamList = new ArrayList<>();
    public Team red;
    public Team blue;
    public Team green;
    public Team yellow;
    public List<Team> deadTeams = new ArrayList<>();


    public void start() {
        //Setting the teams
        //Each player will be set into a team until its full, then the next team will be filled
        //All teams together will be stored in a list called teamList
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
                    teamList.get(i).setActive(true);
                    board.updateScoreboard();

                    break;
                }
            }
        });
        //setTeamsActive();
        setDeadTeams();
    }

    //This will be in world reset function
    //It removes all items from the map
    public void deleteItems() {
        Bukkit.getServer().getWorld("world_bedwars").getEntities().forEach(e -> {
            if (e instanceof Item item) {
                item.remove();
            }
        });
    }


    //Well sometimes we need to know wich team a player is in
    //This method will check it and return the whole team
    public Team getPlayerTeam(Player player) {
        for (int i = 0; i < 4; i++) {
            if (teamList.get(i).getPlayers().contains(player)) {
                return teamList.get(i);
            }
        }
        return null;
    }

    //Checks if the bed is active or not
    public int isBedActiv(Player player) {
        Team team = getPlayerTeam(player);
        if (team.isBedActive()) {
            return 1;
        } else {
            return 0;
        }
    }

    //This is very important for the game
    //Sometime a player will not be teleported from the lobby to the game world
    //This method shall fix this, but it is not completely done as of now
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

    //Teleports each player of a team to its correct team spawn
    public void teleportTeams() {
        teamList.forEach(team -> {
            if (team.getPlayerCount() > 0) {
                team.getPlayers().forEach(p -> {
                    p.teleport(team.getTeamSpawn());
                });
            }
        });
    }

    public void setTeamsActive() {
        teamList.forEach(team -> {
            if(team.getPlayerCount() > 0) {
                team.setActive(true);
            }
        });
    }

    //We have a method that returns the blocks around a teamspawn
    //This will prevent trapping players in their spawn
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

    public boolean teamWon() {
        int activeTeams = 0;
        for (int i = 0; i < 4; i++) {
            if (teamList.get(i).isBedActive()) {
                activeTeams++;
            }
        }
        return activeTeams == 1;
    }

    public void setDeadTeams() {
        for (int i = 0; i < 4; i++) {
            if (teamList.get(i).getPlayerCount() == 0) {
                if(!deadTeams.contains(teamList.get(i))) {
                    deadTeams.add(teamList.get(i));
                }
            }
        }
    }

    public Team getWinner() {
        if(deadTeams.size() == 3) {
            for (int i = 0; i < 4; i++) {
                if (deadTeams.contains(teamList.get(i))) {
                    continue;
                } else {
                    return teamList.get(i);
                }
            }
            return null;
        }
        return null;
    }

}
