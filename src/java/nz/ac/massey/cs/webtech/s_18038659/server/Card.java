/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.massey.cs.webtech.s_18038659.server;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import javax.imageio.ImageIO;
import static org.eclipse.jdt.internal.compiler.parser.Parser.name;

/**
 *
 * @author 18038659
 */
public class Card {
    private String faceName,suit,pictureName;
    private int faceValue;
    private BufferedImage cardImage;
   // private String pictureName
    //private Image image;
    
//    backofCard = new cardImage("./game/back-blue_.png");
 
    
    /**
     * 
     * @param faceName = 2,3,4,5,6,7,8,9,10,Jack,Queen,King,Ace
     * @param suit "spades","clubs","diamonds","hearts"
     * @param faceValue = 2,3,4,5,6,7,8,9,10,11,12,13,14
     * @param cardImage 
     */
    
    public Card(String faceName, String suit, int faceValue, BufferedImage cardImageName) throws IOException {
        this.faceName = faceName;
        this.suit = suit;
        this.faceValue = faceValue;
        
        //String pictureName = ("/.game/"+faceName+suit+".png");
       // this.cardImage = ImageIO.read(new File(pictureName));
        //this.cardImage = cardImage;
       
        //cardImage = BufferedImage("./game/"+pictureName);
    }
    
    /**
     * This method returns a list of face names that are valid
     * @return 
     */
    
    public static List<String> getvalidFaceNames()
    {
        return Arrays.asList("2","3","4","5","6","7","8","9","10","j","q","k","a");
    }

    public Card() {
        
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

    public BufferedImage getCardImage() {
        return cardImage;
    }

    public void setCardImage(BufferedImage cardImage) {
        this.cardImage = cardImage;
    }
    
    
    
}
