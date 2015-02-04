import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and Mous eInfo)
import java.awt.Color;
/**
 * Message is a singleton Class for displaying interactive messages.
 * to the audience regarding explaining the Scrum game rules
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Message extends Actor
{
    protected abstract void setTextMessage(String message);
     
}
