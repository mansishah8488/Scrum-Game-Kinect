/**
 * Write a description of class RollDice here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RollDice implements ActionStrategy  
{
    // instance variables - replace the example below with your own
    private GamePiece player;
    private int dice_sum;
    private int p;
    private DiceSumMessage diceSumMessage;
    private HoursMessage hoursMessage;
    
    public RollDice(GamePiece player, int dice_sum)
    {
        this.player = player;
        this.dice_sum = dice_sum;
    }

    public void performTask(){
        p = player.getPosition();
        diceSumMessage = DiceSumMessage.getMessageInstance();
        hoursMessage = HoursMessage.getMessageInstance();
        
        if((p == 15) || (p == 21))
            ScrumWorld.TOTAL_HOURS -= dice_sum;
        
        if((p == 19) || (p == 22))
            ScrumWorld.TOTAL_HOURS -= (2*dice_sum);
        
        if((p == 20) || (p == 23))
            ScrumWorld.TOTAL_HOURS += dice_sum;
        
        //Print the total hours + dice Sum graphically
        System.out.println("TOTAL HOURS = " + ScrumWorld.TOTAL_HOURS);
        if(ScrumWorld.TOTAL_HOURS <0)
        {
            hoursMessage.setTextMessage("0");
        }else
        {
            hoursMessage.setTextMessage( Integer.toString(ScrumWorld.TOTAL_HOURS));
        }
        diceSumMessage.setTextMessage(Integer.toString(this.dice_sum));
        
    }
    
    public void performGraphicDrawCard()
    {
    }
}
