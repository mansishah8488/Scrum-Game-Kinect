import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class GameRulesMessage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameRulesMessage extends Message
{
    private static GameRulesMessage messageInstance = new GameRulesMessage( );
   
    private static GreenfootImage gImage;
    private GameRulesMessage()
    {
       gImage = new GreenfootImage(170, 75);
       setImage(gImage);
    }
     
     public static GameRulesMessage getMessageInstance()
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
