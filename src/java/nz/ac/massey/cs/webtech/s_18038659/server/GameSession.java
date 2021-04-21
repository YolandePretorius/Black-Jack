/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.massey.cs.webtech.s_18038659.server;

/**
 *
 * @author 18038659
 */
public class GameSession {
    Card[] playerCards;
    Card[] dealerCards;
    boolean isPlayersTurn;

    public Card[] getPlayerCards() {
        return playerCards;
    }

    public void setPlayerCards(Card[] playerCards) {
        this.playerCards = playerCards;
    }

    public Card[] getDealerCards() {
        return dealerCards;
    }

    public void setDealerCards(Card[] dealerCards) {
        this.dealerCards = dealerCards;
    }

    public boolean isIsPlayersTurn() {
        return isPlayersTurn;
    }

    public void setIsPlayersTurn(boolean isPlayersTurn) {
        this.isPlayersTurn = isPlayersTurn;
    }
   
}
