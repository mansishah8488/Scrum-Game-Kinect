import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class Cards extends Actor
{   

    public abstract String drawCard();    
    public abstract void discardCard(String cardCardMessage);
    public abstract void shuffleCard();
    public abstract void showDrawnCard(String cardMessage);
}
