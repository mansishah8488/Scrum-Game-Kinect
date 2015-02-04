import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class DiceSumMessage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DiceSumMessage extends Message
{
    private static DiceSumMessage messageInstance = new DiceSumMessage( );
   
    private static GreenfootImage gImage;
    private DiceSumMessage()
    {
       gImage = new GreenfootImage(50, 50);
       setImage(gImage);
    }
     
     public static DiceSumMessage getMessageInstance()
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
