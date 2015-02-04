import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class CardMessage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CardMessage extends Message
{
    private static CardMessage messageInstance = new CardMessage( );
   
    private GreenfootImage gImage;
    private CardMessage()
    {
       gImage = new GreenfootImage(245,180);
       setImage(gImage);
    }
     
     public static CardMessage getMessageInstance()
     {    
         return messageInstance;
     }
     
     //Method to draw message relative to the message pop up
     protected void setTextMessage(String message)
     {
        gImage.clear();
        Color bgColor = new Color(0, 0, 0, 0); // transparent background  
        gImage.setColor (bgColor);
        gImage.fill();
        gImage.setColor (Color.BLACK);
        gImage.drawString (message ,1, 10);
     }   
}
