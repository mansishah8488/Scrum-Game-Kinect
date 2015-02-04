import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

public abstract class Dice extends Actor
{
    int max = 7, min = 1;
    boolean first_turn = true;
    public Dice() 
    {
        //dice_count++;
    }
    
    public abstract int[] roll(int player_position);

    int getRandomValue()
    {
        Random rand = new Random();
        int value = rand.nextInt((max - min)) + min;
        return value;
    }
}
