import greenfoot.*;

public class Burn implements ActionStrategy
{
    GamePiece player;
    private GameRulesMessage message;
    private HoursMessage hoursMessage;
    public Burn(GamePiece player)
    {
        this.player = player;
        message = GameRulesMessage.getMessageInstance();
    }
    
    public void performTask()
    {
        this.player = player;
        hoursMessage = HoursMessage.getMessageInstance();
        if((player.getPosition() == 1) || (player.getPosition() == 5))
        {
            ScrumWorld.TOTAL_HOURS += 50;
            message.setTextMessage("Adding 50 hours to total \n burndown hours!");
            ScrumWorld.backgroundMusic = new GreenfootSound("Adding 50 hours.mp3");
            ScrumWorld.backgroundMusic.play();
            Greenfoot.delay(200);
        }
        else if(player.getPosition() == 3)
        {
            ScrumWorld.TOTAL_HOURS += 25;
            message.setTextMessage("Adding 25 hours to total \n burndown hours!");
            ScrumWorld.backgroundMusic = new GreenfootSound("Adding 25 hours.mp3");
            ScrumWorld.backgroundMusic.play();
            Greenfoot.delay(200);
        }                 
        else
        {
            ScrumWorld.TOTAL_HOURS -= 25; 
            message.setTextMessage("25 hours have been burnt down!");
            ScrumWorld.backgroundMusic = new GreenfootSound("25 Hours Burnt Down.mp3");
            ScrumWorld.backgroundMusic.play();
            Greenfoot.delay(200);
        }
              
            
        //Print the total hours graphically
        if(ScrumWorld.TOTAL_HOURS <0)
        {
            hoursMessage.setTextMessage("0");
        }else
        {
            hoursMessage.setTextMessage( Integer.toString(ScrumWorld.TOTAL_HOURS));
        }
        System.out.println("TOTAL HOURS = " + ScrumWorld.TOTAL_HOURS);
    }
    
    public void performGraphicDrawCard()
    {
    }
    
}
