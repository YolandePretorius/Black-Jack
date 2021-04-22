/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.massey.cs.webtech.s_18038659.server;

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
    
  

    List<Integer> listFace = Arrays.asList(2,3,4,5,6,7,8,9,10);
    List<String> listFace2 = Arrays.asList("j","q","k");
    List<String> listSuit = Arrays.asList("d","h","c","s");
    List<Card> deckCards = new ArrayList<>();
    List<Card>playerCards = new ArrayList<>();
    List<Card>dealerCards = new ArrayList<>();

   void setInitialGameState(GameSession gameState) {   
       getDeckOfCards();
       playerCards.add(DrawCard());
       playerCards.add(DrawCard());
       dealerCards.add(DrawCard());
       dealerCards.add(DrawCard());
   }

    public void getDeckOfCards(){
        for (Integer cardFace : listFace) {
            for (String cardSuit : listSuit) {
                Card newCard = new Card();
                newCard.setFaceName(cardFace.toString());
                newCard.setSuit(cardSuit);
                newCard.setFaceValue(cardFace);
                
                //newCard.setCardImage(cardFace.toString() + cardSuit + "png");
                
                deckCards.add(newCard);
            }
            
        }
        for (String cardFace : listFace2) {
            for (String cardSuit : listSuit) {
                Card newCard = new Card();
                newCard.setFaceName(cardFace);
                newCard.setSuit(cardSuit);
                newCard.setFaceValue(10);
                //newCard.setCardImage(./game/2c.png);
                deckCards.add(newCard);
            }
            
        }       
            for (String cardSuit : listSuit) {
                Card newCard = new Card();
                newCard.setFaceName("a");
                newCard.setSuit(cardSuit);
                newCard.setFaceValue(11);
                deckCards.add(newCard);
            }
   }

    private Card DrawCard() {
        Random rand = new Random();
        Card card = deckCards.get(rand.nextInt(deckCards.size()));
        deckCards.remove(card);
        return card;
    }

}

    
    

