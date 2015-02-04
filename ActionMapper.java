import greenfoot.*;

public class ActionMapper  
{
    GameRulesMessage message;
    private int p;
    private ActionStrategy as;
    private boolean isUser = false;
    public ActionStrategy getAction(GamePiece player, int dice_sum, GamePlay gameplay)
    {
        p = player.getPosition();
        message = GameRulesMessage.getMessageInstance();
        if((p == 6)||(p == 10)||(p == 14))
        {
            //Display message
            System.out.println("Team reached End Of Day!!");
            message.setTextMessage("Player "+ player.getId()+" reached end of day!");
            ScrumWorld.backgroundMusic = new GreenfootSound("Player Eod.mp3");
            ScrumWorld.backgroundMusic.play();
            Greenfoot.delay(200);
            as = new EndDay();
        }
            
            
        if((p == 7)||(p == 11)||(p == 16) && ScrumWorld.TOTAL_HOURS > 0){
            isUser = true;
            //Display message
            System.out.println("Player "+ player.getId()+": Draw Impediment Card!!");
            message.setTextMessage("Player "+ player.getId()+":Draw Impediment \nCard!");
            if(ScrumWorld.TOTAL_HOURS >0 && ScrumWorld.TOTAL_DAYS>0)
            {
                ScrumWorld.backgroundMusic = new GreenfootSound("Pick Impediment.mp3");
                ScrumWorld.backgroundMusic.play();
                Greenfoot.delay(200);
            }
            as = new Impediment(player);
        }
        
        if((p == 8)||(p == 12)||(p == 17) && ScrumWorld.TOTAL_HOURS > 0){
            isUser = true;
             //Display message
            System.out.println("Player "+ player.getId()+":Draw Opportunity Card!!");
            message.setTextMessage("Player "+ player.getId()+":Draw Opportunity \nCard!");
            if(ScrumWorld.TOTAL_HOURS >0 && ScrumWorld.TOTAL_DAYS>0)
            {
                ScrumWorld.backgroundMusic = new GreenfootSound("Pick Opportunity.mp3");
                ScrumWorld.backgroundMusic.play();
                Greenfoot.delay(200);
            }
            as = new Opportunity(player,gameplay);
        }
            
        if((p == 9)||(p == 13)||(p == 18) && ScrumWorld.TOTAL_HOURS > 0){
            isUser = true;
            //Display message
            System.out.println("Player "+ player.getId()+":Draw Tool Card!!");
            message.setTextMessage("Player "+ player.getId()+":Draw Tool Card!");
            if(ScrumWorld.TOTAL_HOURS >0 && ScrumWorld.TOTAL_DAYS>0)
            { 
                ScrumWorld.backgroundMusic = new GreenfootSound("Pick Tool.mp3");
                ScrumWorld.backgroundMusic.play();
                Greenfoot.delay(200);
            }
            as = new Tool(player);
        }
        
        if((p == 1) || (p == 3) || (p == 4)||(p == 5) && ScrumWorld.TOTAL_HOURS > 0)
            as = new Burn(player);
            
        if((p == 15) || (p >= 19) && (p < 24) && ScrumWorld.TOTAL_HOURS > 0)
        {
            //Display message
            System.out.println("Player "+ player.getId()+":Roll progress dice");
            message.setTextMessage("Player "+ player.getId()+":Roll progress dice!");
            
            if(ScrumWorld.TOTAL_HOURS >0 && ScrumWorld.TOTAL_DAYS>0)
            {
                ScrumWorld.backgroundMusic = new GreenfootSound("Roll Progress Dice.mp3");
                ScrumWorld.backgroundMusic.play();
                Greenfoot.delay(200);
            }
            as = new RollDice(player, dice_sum);    
               
        }
        
        if(p == 2)
        {
            //Display message
            System.out.println("Player "+ player.getId()+":Take additional \nprogress dice!");
            message.setTextMessage("Player "+ player.getId()+":Take additional \nprogress dice!");
            if(ScrumWorld.TOTAL_HOURS >0 && ScrumWorld.TOTAL_DAYS>0)
            {
                ScrumWorld.backgroundMusic = new GreenfootSound("Take Add Prog Dice.mp3");
                ScrumWorld.backgroundMusic.play();
                Greenfoot.delay(200);
            }
            as = new TakeDice();
        }
            
        return as;    
    }
    
    public boolean userRequired(){
        return isUser;
    }
}
