import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
public class ToolCard extends Cards
{
    public static Queue<String> TOOL_CARDS = new LinkedList<String>();
    public static Queue<String> DIS_TOOL_CARDS = new LinkedList<String>();
    GameRulesMessage message;
    private static ScrumWorld myworld;

    public String drawCard(){
        String cardMessage="";
        try{
            message = GameRulesMessage.getMessageInstance();
            message.setTextMessage("Pick a tool card \n by clicking on deck \nof tool cards \nusing left hand");
            ScrumWorld.backgroundMusic = new GreenfootSound("Pick Tool.mp3");
            ScrumWorld.backgroundMusic.play();
            Greenfoot.delay(200);
            boolean checkLeftHandUp = false;
            
           while(!checkLeftHandUp)
            {
               if(myworld.isLeftHandUp())
                {
                    System.out.println("Successfuly Drew Tool Card");
                    cardMessage = TOOL_CARDS.peek();
                    showDrawnCard(cardMessage);
                    TOOL_CARDS.remove();
                    checkLeftHandUp = true;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception caught in drawcard() ToolCard");
        }
        return cardMessage;
    }
    
    public static void getWorld(ScrumWorld world){
        myworld = world;
    }
    
    public void discardCard(String card){
        DIS_TOOL_CARDS.add(card);
    }
    
    public void shuffleCard(){
        for(int i=0;i<DIS_TOOL_CARDS.size();i++)
        {
            TOOL_CARDS.add(DIS_TOOL_CARDS.peek());
            DIS_TOOL_CARDS.remove();
        }
    }
    
    public void showDrawnCard(String cardMessage)
    {
        BackCard backCard = new BackCard(cardMessage);
        backCard.addCardGraphically();
    }
    
}
