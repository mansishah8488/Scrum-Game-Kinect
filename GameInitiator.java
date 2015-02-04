import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GameInitiator extends Actor
{
    GamePlay gameplay;
    public GameInitiator(GamePlay gameplay)
    {
        this.gameplay = gameplay;
    }
    
    public void act(){
        if(Greenfoot.mousePressed(this)){
            System.out.println("Game Play object:" + gameplay);
            gameplay.diceRolled(gameplay);
        }
    }    
}
