import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PlayDice extends Dice
{
    int[] dice_value = new int[2];
    DiceSumMessage message;
    //boolean first_turn = true;
    public void act() 
    {
        // Add your action code here.
    }  
    
    public int[] roll(int player_position)
    {
        if(player_position == 0)
        {
            dice_value[0] = getRandomValue();
            dice_value[1] = 0;
            //first_turn = false;
            return dice_value;
        }
        else
        {
            dice_value[0] = getRandomValue();
            dice_value[1] = getRandomValue();
            return dice_value;
        }
    }
    
    public int getSum(int[] dice_value)
    {
        int sum = dice_value[0] + dice_value[1];
        message = DiceSumMessage.getMessageInstance();
        message.setTextMessage(Integer.toString(sum));
        return sum;
    }
}
