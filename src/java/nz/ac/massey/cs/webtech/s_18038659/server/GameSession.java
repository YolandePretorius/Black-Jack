/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.massey.cs.webtech.s_18038659.server;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 18038659
 */
public class GameSession {
    List<Card> playerCards = new ArrayList<>();
    List<Card> dealerCards = new ArrayList<>();
    boolean isPlayersTurn;
    List<Card> Deck = new ArrayList<>();
    int numberGamesPlayed;

    public List<Card> getPlayerCards() {
        return playerCards;
    }

    public void setPlayerCards(List<Card> playerCards) {
        this.playerCards = playerCards;
    }

    public List<Card> getDealerCards() {
        return dealerCards;
    }

    public void setDealerCards(List<Card> dealerCards) {
        this.dealerCards = dealerCards;
    }

    public boolean isIsPlayersTurn() {
        return isPlayersTurn;
    }

    public void setIsPlayersTurn(boolean isPlayersTurn) {
        this.isPlayersTurn = isPlayersTurn;
    }

    public List<Card> getDeck() {
        return Deck;
    }

    public void setDeck(List<Card> Deck) {
        this.Deck = Deck;
    }

    @Override
    public String toString() {
        return "GameSession{" + "playerCards=" + playerCards + ", dealerCards=" + dealerCards + ", isPlayersTurn=" + isPlayersTurn + ", Deck=" + Deck + '}';
    }

    List<Card> setPlayerCards() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 

    
    
}
