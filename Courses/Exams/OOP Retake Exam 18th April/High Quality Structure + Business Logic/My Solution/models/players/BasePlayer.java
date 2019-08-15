package models.players;

import models.players.interfaces.Player;
import repositories.interfaces.CardRepository;

public abstract class BasePlayer implements Player {
    private static final int HEALTH_POINTS_MIN = 0;
    private static final int DAMAGE_POINTS_MIN = 0;

    private String username;
    private int health;
    private CardRepository cardRepository;
    private boolean isDead;

    protected BasePlayer(CardRepository cardRepository, String username, int health) {
        setUsername(username);
        setHealth(health);
        setCardRepository(cardRepository);
        setDead(false);
    }

    private void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Player's username cannot be null or an empty string.");
        }

        this.username = username;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public void setHealth(int health) {
        if (health < HEALTH_POINTS_MIN) { // what if it is 0? dead=true?
            throw new IllegalArgumentException("Player's health bonus cannot be less than zero.");
        }

        if (health == 0) setDead(true);

        this.health = health;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    private void setCardRepository(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public CardRepository getCardRepository() {
        return this.cardRepository;
    }

    private void setDead(boolean dead) {
        this.isDead = dead;
    }

    @Override
    public boolean isDead() {
        return this.isDead;
    }

    public void takeDamage(int damagePoints) {
        if (damagePoints < DAMAGE_POINTS_MIN) {
            throw new IllegalArgumentException("Damage points cannot be less than zero.");
        }

        this.health -= damagePoints;

        if (this.health <= HEALTH_POINTS_MIN) {
            this.health = HEALTH_POINTS_MIN;
            this.isDead = true;
        }
    }


}
