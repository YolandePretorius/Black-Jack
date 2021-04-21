/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.massey.cs.webtech.s_18038659.server;

import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author 18038659
 */
public class Card {
    private String faceName,suit,pictureName;
    private int faceValue;
    private byte cardImage;
 
    
    /**
     * 
     * @param faceName = 2,3,4,5,6,7,8,9,10,Jack,Queen,King,Ace
     * @param suit "spades","clubs","diamonds","hearts"
     * @param faceValue = 2,3,4,5,6,7,8,9,10,11,12,13,14
     * @param cardImage 
     */
    public Card(String faceName, String suit, int faceValue, byte cardImage) {
        this.faceName = faceName;
        this.suit = suit;
        this.faceValue = faceValue;
        this.cardImage = cardImage;
    }
    
    /**
     * This method returns a list of face names that are valid
     * @return 
     */
    
    public static List<String> getvalidFaceNames()
    {
        return Arrays.asList("2","3","4","5","6","7","8","9","10","Jack","queen","king","ace");
    }

    public String getFaceName() {
        return faceName;
    }

    public void setFaceName(String faceName) {
        List<String> validFaceNames = getvalidFaceNames();
        faceName = faceName.toLowerCase();
        if(validFaceNames.contains(faceName))
                this.faceName = faceName;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }
    

    public int getFaceValue() {
        return faceValue;
    }
    
    public void setFaceValue(int faceValue) {
        this.faceValue = faceValue;
    }

    public byte getCardImage() {
        return cardImage;
    }

    public void setCardImage(byte cardImage) {
        this.cardImage = cardImage;
    }
    
    
    
}
