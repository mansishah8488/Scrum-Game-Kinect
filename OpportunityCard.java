import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
public class OpportunityCard extends Cards
{
    public static Queue<String> OPPORTUNITY_CARDS = new LinkedList<String>();
    private static ScrumWorld myworld;
    GameRulesMessage message;
    public String drawCard(){
        String cardMessage="";
        try{
            System.out.println("Pick a opportunity card \n by clicking on deck \nof opportunity cards \nusing left hand");
            message = GameRulesMessage.getMessageInstance();
            message.setTextMessage("Pick an opportunity card \n by clicking on deck \nof opportunity cards \nusing left hand");
            ScrumWorld.backgroundMusic = new GreenfootSound("Pick Opportunity.mp3");
            ScrumWorld.backgroundMusic.play();
            Greenfoot.delay(200);
            System.out.println("wrld : " + myworld);
            boolean checkLeftHandUp = false;
            
            while(!checkLeftHandUp)
            {
                if(myworld.isLeftHandUp())
                {
                    System.out.println("Successfuly Drew Opportunity Card");
                    cardMessage = OPPORTUNITY_CARDS.peek();
                    showDrawnCard(cardMessage);
                    OPPORTUNITY_CARDS.remove();
                    checkLeftHandUp = true;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception caught in drawcard() Opportunity");
        }
        return cardMessage;
    }
    
    public static void getWorld(ScrumWorld world){
        myworld = world;
    }
    
    public void shuffleCard(){
        // Do nothing
    }
    
    public void discardCard(String card){
        // Add your action code here.
    }
    
    public void showDrawnCard(String cardMessage)
    {
        BackCard backCard = new BackCard(cardMessage);
        backCard.addCardGraphically();   
    }
    
}
