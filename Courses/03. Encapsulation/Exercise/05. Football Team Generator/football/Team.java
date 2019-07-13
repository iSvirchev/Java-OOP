package football;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        setName(name);
        players = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String playerName) {
        Player playerToDelete = new Player();
        boolean playerFound = false;

        for (Player player : this.players) {
            if (player.getName().equals(playerName)) {
                playerToDelete = player;
                playerFound = true;
            }
        }

        if (playerFound) {
            this.players.remove(playerToDelete);
        }else{
            throw new IllegalArgumentException("Player " + playerName + " is not in " + this.getName() + " team.");
        }
    }

    public double getRating() {
        double skillRating = 0;

        for (Player player : players) {
            skillRating += player.overallSkillLevel();
        }

        return skillRating;
    }
}
