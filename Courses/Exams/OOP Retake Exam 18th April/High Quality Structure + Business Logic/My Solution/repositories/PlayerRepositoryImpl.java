package repositories;

import models.players.interfaces.Player;
import repositories.interfaces.PlayerRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerRepositoryImpl implements PlayerRepository {

    private List<Player> players;

    public PlayerRepositoryImpl() {
        this.players = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.players.size();
    }

    @Override
    public List<Player> getPlayers() {
        return Collections.unmodifiableList(this.players);
    }

    @Override
    public void add(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }

        if (this.players.contains(find(player.getUsername()))) {
            throw new IllegalArgumentException(String.format("Player %s already exists!", player.getUsername()));
        }

        this.players.add(player);
    }

    @Override
    public boolean remove(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Player cannot be null");
        }

        return this.players.remove(player);
    }

    @Override
    public Player find(String name) {
        Player findThisPlayer = null;

        for (Player player : this.players) {
            if (player.getUsername().equals(name)) {
                findThisPlayer = player;
            }
        }

        return findThisPlayer;
    }
}
