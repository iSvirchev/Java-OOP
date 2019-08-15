package core;

import core.interfaces.ManagerController;
import models.battleFields.BattleFieldImpl;
import models.battleFields.interfaces.Battlefield;
import models.cards.MagicCard;
import models.cards.TrapCard;
import models.cards.interfaces.Card;
import models.players.Advanced;
import models.players.Beginner;
import models.players.interfaces.Player;
import repositories.CardRepositoryImpl;
import repositories.PlayerRepositoryImpl;
import repositories.interfaces.CardRepository;
import repositories.interfaces.PlayerRepository;

import static common.ConstantMessages.*;


public class ManagerControllerImpl implements ManagerController {
    private CardRepository cardRepository;
    private PlayerRepository playerRepository;
    private Battlefield battlefield;

    public ManagerControllerImpl() {
        this.cardRepository = new CardRepositoryImpl();
        this.playerRepository = new PlayerRepositoryImpl();
        this.battlefield = new BattleFieldImpl();
    }

    @Override
    public String addPlayer(String type, String username) {
        Player player = null;

        if (type.equalsIgnoreCase("beginner")) {
            player = new Beginner(new CardRepositoryImpl(), username);
        } else {
            player = new Advanced(new CardRepositoryImpl(), username);
        }

        playerRepository.add(player);

        return String.format(SUCCESSFULLY_ADDED_PLAYER, type, username);
    }

    @Override
    public String addCard(String type, String name) {
        Card card = null;

        if (type.equalsIgnoreCase("Trap")) {
            card = new TrapCard(name);
        } else {
            card = new MagicCard(name);
        }

        this.cardRepository.add(card);

        return String.format(SUCCESSFULLY_ADDED_CARD, type, name);
    }

    @Override
    public String addPlayerCard(String username, String cardName) {
        Player player = playerRepository.find(username);
        Card card = cardRepository.find(cardName);
        player.getCardRepository().add(card);

        return String.format(SUCCESSFULLY_ADDED_PLAYER_WITH_CARDS, cardName,username);
    }

    @Override
    public String fight(String attackUser, String enemyUser) {
        Player attacker = playerRepository.find(attackUser);
        Player enemy = playerRepository.find(enemyUser);

        this.battlefield.fight(attacker,enemy);

        return String.format(FIGHT_INFO,String.valueOf(attacker.getHealth()),String.valueOf(enemy.getHealth()));
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        for (Player player : this.playerRepository.getPlayers()) {
            sb.append(String.format(PLAYER_REPORT_INFO,player.getUsername(), player.getHealth(),player.getCardRepository().getCount()));
            sb.append("\n");
            for (Card card : player.getCardRepository().getCards()) {
                sb.append(String.format(CARD_REPORT_INFO, card.getName(),card.getDamagePoints()));
                sb.append("\n");
            }
            sb.append(DEFAULT_REPORT_SEPARATOR).append("\n");
        }

        return sb.toString();
    }

}
