/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.massey.cs.webtech.s_18038659.server;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *
 * @author 18038659
 */
public class Card {

    private String faceName, suit;
    private int faceValue;
    private BufferedImage cardImage;
    public String cardURL;
    private String pictureName;
    //private Image image;

//    backofCard = new cardImage("./game/back-blue_.png");
//    public void setPictureName(String pictureName) {
//        this.pictureName = pictureName;
//    }
    /**
     *
     * @param faceName = 2,3,4,5,6,7,8,9,10,Jack,Queen,King,Ace
     * @param suit "spades","clubs","diamonds","hearts"
     * @param faceValue = 2,3,4,5,6,7,8,9,10,11,12,13,14
     * @param cardImage
     *
     */
    public Card() throws IOException {
//        this.pictureName = ("../game/"+faceName+suit+".png");
//        this.cardImage = ImageIO.read(new File(pictureName));
    }

    public Card(String faceName, String suit, int faceValue, BufferedImage cardImageName) throws IOException {

        this.faceName = faceName;
        this.suit = suit;
        this.faceValue = faceValue;

        /**
         *
         */
//          cardImage = ImageIO.read(new File(pictureName));
//        try{
//            cardImage = ImageIO.read(new File(pictureName));
//        }catch(IOException e){
//    
//        }
        //this.cardImage = cardImage;
        //cardImage = BufferedImage("./game/"+pictureName);
    }

    /**
     * This method returns a list of face names that are valid
     *
     * @return
     */
    public static List<String> getvalidFaceNames() {
        return Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace");
    }

    public String getFaceName() {
        return faceName;
    }

    public void setFaceName(String faceName) {
        List<String> validFaceNames = getvalidFaceNames();
        faceName = faceName.toLowerCase();
        if (validFaceNames.contains(faceName)) {
            this.faceName = faceName;
        }
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

//    public BufferedImage getCardImage() throws IOException {
//        this.pictureName = (faceName+suit+".png");
//        this.cardImage = ImageIO.read(new File("./game/"+pictureName));
//        return this.cardImage;
//    }
    public void setCardURL(String url) {

    }

    public String getCardURL(String url) {
        this.pictureName = (faceName + suit + ".png");
        return this.cardURL = (url + "game/" + pictureName);
    }

}
