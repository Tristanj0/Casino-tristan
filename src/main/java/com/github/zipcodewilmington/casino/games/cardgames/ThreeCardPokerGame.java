package com.github.zipcodewilmington.casino.games.cardgames;

import com.github.zipcodewilmington.casino.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ThreeCardPokerGame implements GameInterface {

    private Deck deck;
    private HashSet<ThreeCardPokerPlayer> playerSet;
    private List<Card> dealerHand;

    public ThreeCardPokerGame(HashSet<ThreeCardPokerPlayer> playerSet) {
        this.deck = new Deck();
        this.playerSet = playerSet;
        this.dealerHand = new ArrayList<>();
    }

    public List<Card> dealHand() {
        List<Card> threeCardHand = new ArrayList<>();
        threeCardHand.add(deck.dealTop());
        threeCardHand.add(deck.dealTop());
        threeCardHand.add(deck.dealTop());
        //dealerHand = threeCardHand;
        return threeCardHand;
    }

    public StringBuilder flipCards() {
        StringBuilder allCards = new StringBuilder(" * * Dealer's Hand * *\n");
        for(Card card : dealerHand) {
            allCards.append(card).append("\n");
        }
        for(ThreeCardPokerPlayer player : playerSet) {
            allCards.append(" * * ").append(player.getPlayerName()).append("'s Hand * *\n");
            for(Card card : player.getPlayerHand()) {
                allCards.append(card).append("\n");
            }
        }

        return allCards;
    }

    @Override
    public void beginGame() {
        System.out.println(printInstructions());
        dealerHand = dealHand();
        for(ThreeCardPokerPlayer player : playerSet) {
            player.setPlayerHand(dealHand());
        }
        System.out.println(flipCards());
    }

    @Override
    public String printInstructions() {
        return "-------------------------------\n" +
               "--Welcome to Three Card Poker--\n" +
               "-------------------------------\n" +
               "I don't know the rules, good luck.";
    }

    @Override
    public Player decideWinner() {
        return null;
    }
}
