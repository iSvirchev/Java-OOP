package models.battleFields;

import models.battleFields.interfaces.Battlefield;
import models.cards.interfaces.Card;
import models.players.Beginner;
import models.players.interfaces.Player;
import repositories.interfaces.CardRepository;

public class BattleFieldImpl implements Battlefield {

    @Override
    public void fight(Player attackPlayer, Player enemyPlayer) {
        if (enemyPlayer.isDead() || attackPlayer.isDead()) {
            throw new IllegalArgumentException("Player is dead!");
        }

        // Both player's card repositories
        CardRepository attackPlayerCR = attackPlayer.getCardRepository();
        CardRepository enemyPlayerCR = enemyPlayer.getCardRepository();

        // if player is a beginner - increase health + 40 and every card's dmg +30
        enhanceBeginners(attackPlayer, attackPlayerCR);
        enhanceBeginners(enemyPlayer, enemyPlayerCR);

        // Increases player's health for every card's health in his deck
        increaseHealth(attackPlayer, attackPlayerCR);
        increaseHealth(enemyPlayer, enemyPlayerCR);

        while (true) {
            // First Player attacks
            int attackPlayerDMG = getTotalCardDamage(attackPlayerCR);
            enemyPlayer.takeDamage(attackPlayerDMG);
            if (enemyPlayer.isDead()) return;

            // Second Player attacks
            int enemyPlayerDMG = getTotalCardDamage(enemyPlayerCR);
            attackPlayer.takeDamage(enemyPlayerDMG);
            if (attackPlayer.isDead()) return;
        }
    }

    private void increaseHealth(Player player, CardRepository cardRepository) {
        int bonusHP = getTotalCardHP(cardRepository);
        player.setHealth(player.getHealth() + bonusHP);
    }

    private int getTotalCardHP(CardRepository cardRepository) {
        return cardRepository.getCards().stream().mapToInt(Card::getHealthPoints).sum();
    }

    private int getTotalCardDamage(CardRepository cardRepository) {
        return cardRepository.getCards().stream().mapToInt(Card::getDamagePoints).sum();
    }

    private void enhanceBeginners(Player player, CardRepository cardRepository) {
        if (player.getClass().getSimpleName().equalsIgnoreCase(Beginner.class.getSimpleName())) {
            int newHealth = player.getHealth() + 40;
            player.setHealth(newHealth);
            for (Card card : cardRepository.getCards()) {
                int newDMGPoints = card.getDamagePoints() + 30;
                card.setDamagePoints(newDMGPoints);
            }
        }
    }

}
