import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class HoursMessage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HoursMessage extends Message
{
    private static HoursMessage messageInstance = new HoursMessage( );
   
    private static GreenfootImage gImage;
    private HoursMessage()
    {
       gImage = new GreenfootImage(50, 50);
       setImage(gImage);
    }
     
     public static HoursMessage getMessageInstance()
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
        gImage.setColor (Color.WHITE);
        gImage.drawString (message ,1, 10);
     } 
}
