/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.massey.cs.webtech.s_18038659.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @param faceName = 2,3,4,5,6,7,8,9,10,Jack,Queen,King,Ace
 * @param suit "spades","clubs","diamonds","hearts"
 * @param faceValue = 2,3,4,5,6,7,8,9,10,10,10,10,11/1
 * @param cardImage
 */
public class GameLogic {

    List<Integer> listFace = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10);
    List<String> listFace2 = Arrays.asList("jack", "queen", "king");
    List<String> listSuit = Arrays.asList("diamonds", "hearts", "clubs", "spades");
    List<Card> deckCards = new ArrayList<>();
    List<Card> playerCards = new ArrayList<>();
    List<Card> dealerCards = new ArrayList<>();
    int numberGamesPlayed = 0;
    int totalPlayerScore = 0;
    int totalDealerScore = 0;
    boolean playerWinner = false;

    void setInitialGameState(GameSession gameState) throws IOException {
        createDeckOfCards();
        playerCards.add(DrawCard());
        playerCards.add(DrawCard());
        dealerCards.add(DrawCard());
        dealerCards.add(DrawCard());
        setnumberOfGames();

    }

    public void createDeckOfCards() throws IOException {
        for (Integer cardFace : listFace) {
            for (String cardSuit : listSuit) {
                Card newCard = new Card();
                newCard.setFaceName(cardFace.toString());
                newCard.setSuit(cardSuit);
                newCard.setFaceValue(cardFace);
                deckCards.add(newCard);
            }

        }
        for (String cardFace : listFace2) {
            for (String cardSuit : listSuit) {
                Card newCard = new Card();
                newCard.setFaceName(cardFace);
                newCard.setSuit(cardSuit);
                newCard.setFaceValue(10);
                deckCards.add(newCard);
            }

        }
        for (String cardSuit : listSuit) {
            Card newCard = new Card();
            newCard.setFaceName("ace");
            newCard.setSuit(cardSuit);
            newCard.setFaceValue(11);
            deckCards.add(newCard);
        }
    }

    public void setDeckOfCards(List<Card> sessionDeckOfCards) {
        this.deckCards = sessionDeckOfCards;
    }

    public List<Card> getDeckOfCards() {
        return this.deckCards;
    }

    public List<Card> getDealerCards() {
        return dealerCards;
    }

    public void setDealerCards(List<Card> dealerCards) {
        this.dealerCards = dealerCards;
    }

    public void setPlayerCards(List<Card> sessionPlayersCards) {
        this.playerCards = sessionPlayersCards;
    }

    public List<Card> getPlayerCards() {
        return this.playerCards;
    }

    void playerGetsCard() {
        playerCards.add(DrawCard());
    }

    void dealerGetCard() {
        dealerCards.add(DrawCard());
    }

    private Card DrawCard() {
        Random rand = new Random();
        Card card = deckCards.get(rand.nextInt(deckCards.size()));
        deckCards.remove(card);
        return card;
    }

    private void setnumberOfGames() {
        this.numberGamesPlayed++;
    }

    public int getnumberOfGames() {
        return this.numberGamesPlayed;
    }

    public void setTotalPlayerScore(int totalPlayerScore) {
        this.totalPlayerScore = totalPlayerScore;
    }

    public int getTotalPlayerScore(List<Card> cards) {
        this.totalPlayerScore = 0;
        for (Card playerCard : cards) {
            if (playerCard.getFaceValue() != 11) {
                this.totalPlayerScore = totalPlayerScore + playerCard.getFaceValue();
            }
        }
        for (Card playerCard : cards) {
            if ((playerCard.getFaceValue() == 11) && (this.totalPlayerScore > 10)) {
                this.totalPlayerScore = totalPlayerScore + 1;
            }
            if ((playerCard.getFaceValue() == 11) && (this.totalPlayerScore <= 10)) {
                this.totalPlayerScore = totalPlayerScore + 11;
            }
        }

        return this.totalPlayerScore;
    }

    public int getTotalDealerScore(List<Card> cards) {
        this.totalDealerScore = 0;
        for (Card dealerCard : cards) {
            if (dealerCard.getFaceValue() != 11) {
                this.totalDealerScore = totalDealerScore + dealerCard.getFaceValue();
            }
        }
        for (Card dealerCard : cards) {
            if ((dealerCard.getFaceValue() == 11) && (this.totalDealerScore > 10)) {
                this.totalDealerScore = totalDealerScore + 1;
            }
            if ((dealerCard.getFaceValue() == 11) && (this.totalDealerScore <= 10)) {
                this.totalDealerScore = totalDealerScore + 11;
            }
        }

        return this.totalDealerScore;
    }

    String getWinner(int dealerScore, int playerScore) {
        if (playerScore > 21) {
            return "dealer";
        }
        if ((playerScore <= 21) && (playerScore > dealerScore)) {
            return "player";
        }

        if ((dealerScore <= 21) && (dealerScore > playerScore)) {
            return "dealer";
        }

        if ((playerScore <= 21) && (dealerScore > 21)) {
            return "player";
        }
        if ((playerScore == 21) && (dealerScore == 21)) {
            return "draw";
        }
        if ((playerScore > 21) && (dealerScore <= 21)) {
            return "dealer";
        } else {
            return "draw";
        }
    }

}
