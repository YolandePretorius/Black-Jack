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
    int scorePlayerGame;
    int scoreDealerGame;
    String winner = "none";

    String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getScorePlayerGame() {
        return scorePlayerGame;
    }

    public void setScorePlayerGame(int scorePlayerGame) {
        this.scorePlayerGame = scorePlayerGame;
    }

    public void setNumberGamesPlayed(int numberGamesPlayed) {
        this.numberGamesPlayed = numberGamesPlayed;
    }

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

    public boolean getIsPlayersTurn() {
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

    public int getScoreDealerGame() {
        return scoreDealerGame;
    }

    public void setScoreDealerGame(int scoreDealerGame) {
        this.scoreDealerGame = scoreDealerGame;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "GameSession{" + "playerCards=" + playerCards + ", dealerCards=" + dealerCards + ", isPlayersTurn=" + isPlayersTurn + ", Deck=" + Deck + '}';
    }

    //new
    public PossibleMovesDto getPossibleMovesDto()
    {
        PossibleMovesDto dto = new PossibleMovesDto();
        dto.setIsPlayerTurn(this.isPlayersTurn);
        dto.setCanStand(this.isPlayersTurn);
        dto.setCanHit(this.isPlayersTurn && (this.getScorePlayerGame() < 21));
        
        return dto;
    }
    
    public boolean canHit()
    {
        return this.isPlayersTurn && (this.getScorePlayerGame() < 21);
    }
    
    public boolean canStand()
    {
        return this.isPlayersTurn;
    }
    
    public String getStandLabel()
    {
        if (this.getScorePlayerGame() < 21)
        {
            return "Stand";
        }
        else
        {
            return "Dealer's turn";
        }
    }
}
